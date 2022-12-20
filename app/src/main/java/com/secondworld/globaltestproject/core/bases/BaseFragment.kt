package com.secondworld.globaltestproject.core.bases

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.StringRes
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.secondworld.globaltestproject.core.navigation.Navigator
import com.google.android.material.snackbar.Snackbar
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.core.extension.click
import com.secondworld.globaltestproject.core.extension.hide
import com.secondworld.globaltestproject.core.extension.show
import com.secondworld.globaltestproject.databinding.CustomAlertDialogBinding
import com.secondworld.globaltestproject.ui.MainActivity
import java.lang.IllegalArgumentException
import kotlin.reflect.full.isSubclassOf

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<B : ViewBinding, VM : ViewModel>(
    private val inflate: Inflate<B>, private val clazz : Class<VM>) :
    Fragment(), Navigator {

    private var _viewBinding: B? = null
    protected val binding get() = checkNotNull(_viewBinding)
    lateinit var viewModel: VM
    protected var toolbar: Toolbar? = null

    open val showBtnAddUser = false
    open val showBtnBack = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[clazz]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        listenerBundleArguments()
        initObservers()
        initCallbacks()
    }


    inline fun <reified T> readArguments(
        key: String,
        ifExist: (data: T) -> Unit = {},
        notExist: () -> Unit = {},
    ) {
        if (arguments?.get(key) != null) {

            val data = if (T::class.isSubclassOf(Parcelable::class)) {
                arguments?.getParcelable(key)
            } else {
                when (T::class) {
                    Boolean::class -> arguments?.getBoolean(key)
                    Int::class -> arguments?.getInt(key)
                    String::class -> arguments?.getString(key)
                    Long::class -> arguments?.getLong(key)
                    Short::class -> arguments?.getShort(key)
                    else -> throw IllegalArgumentException("readArguments unknown argument")
                }
            }

            ifExist.invoke(data as T)
            arguments?.remove(key)
        } else {
            notExist.invoke()
        }
    }

    fun readResultAndShowSnackbar(
        result: Boolean,
        positiveMess: String,
        negativeMess: String,
        positiveResult: () -> Unit = {},
        negativeResult: () -> Unit = {},
    ) {
        if (result) {
            positiveResult.invoke()
            showSnackbar(positiveMess)
        } else {
            negativeResult.invoke()
            showSnackbar(negativeMess)
        }
    }

    open fun listenerBundleArguments() = Unit
    open fun initCallbacks() = Unit

    abstract fun initView(): Unit?
    abstract fun initObservers()

    open fun customBackPressed(
        needCheck: Boolean = false,
        successBack: () -> Unit = {},
        cancelBack: () -> Unit = {},
        titleAlert: String = "Предупреждение",
        bodyText: String = "Хотите закончить тестирование?"
    ) {
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {

                override fun handleOnBackPressed() {
                    if (needCheck) {
                        alertDialog(
                            positiveBtnLogic = {
                                if (isEnabled) {
                                    isEnabled = false
                                    navigateUp()
                                    successBack.invoke()
                                }
                            },
                            negativeBtnLogic = {
                                cancelBack.invoke()
                            },
                            titleAlert = titleAlert,
                            bodyText = bodyText
                        )
                    } else {
                        if (isEnabled) {
                            isEnabled = false
                            navigateUp()
                        }
                    }
                }
            })
    }

    @SuppressLint("InflateParams")
    fun alertDialog(
        positiveBtnLogic: () -> Unit = {},
        negativeBtnLogic: () -> Unit = {},
        titleAlert: String = "Внимание",
        bodyText: String = "Предупреждение",
        textPositiveBtn : String = "Да",
        textNegativeBtn : String = "Нет"
    ) {
        val dialogViewBinding = CustomAlertDialogBinding.inflate(LayoutInflater.from(requireActivity())).apply {
            title.text = titleAlert
            body.text = bodyText

            btnPositive.text = textPositiveBtn
            btnNegative.text = textNegativeBtn
        }

        val dialog = AlertDialog.Builder(requireActivity(), R.style.AlertDialog_Custom).create().apply {
            setView(dialogViewBinding.root)
            show()
        }

        dialogViewBinding.btnPositive.click{
            positiveBtnLogic.invoke()
            dialog.dismiss()
        }

        dialogViewBinding.btnNegative.click{
            negativeBtnLogic.invoke()
            dialog.dismiss()
        }
    }

    /**
     * Если нужно отобразить Snackbar, то его всегда можно получить из базового фрагмента.
     * @param view нужно вставить binding.root.
     * @param message сообщение которое вы хотите отобразить в snackbar.
     */
    fun showSnackbar(message: String) {
        Snackbar.make(requireActivity(), binding.root, message, Snackbar.LENGTH_LONG).show()
    }

    /**
     * Функция копирования в буфер обмена
     */
    fun clipToBuffer(str : String) {
        val clipboard = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
        val clip = ClipData.newPlainText("Copied Text", str)
        clipboard!!.setPrimaryClip(clip)

        showSnackbar("Скопировано в буфер обмена")
    }

    /**
     * Если нам нужно отобразить какой то текст из string, то можно использовать этот метод и не
     * инжектить во фрагмент класс [ResourceProvider]
     *
     * @param id передаем id строки из [strings]
     */
    fun string(@StringRes id: Int) {
        requireActivity().getString(id)
    }

    /**
     * Выносим логику навигации в базовый фрагмент, во фрагментах используем метод [navigateTo]
     */
    override fun navigateTo(resId: Int, args: Bundle?, navOptions: NavOptions?) =
        findNavController().navigate(resId, args, navOptions)

    override fun navigateTo(resId: Int, args: Bundle?) = findNavController().navigate(resId, args)

    override fun navigateTo(resId: Int) = findNavController().navigate(resId)

    override fun navigateUp() { findNavController().navigateUp() }

    protected fun <T> LiveData<T>.observe(block: (T) -> Unit) {
        observe(this@BaseFragment.viewLifecycleOwner) { t -> block.invoke(t) }
    }

    /**
     * Очищаем биндинг во всех фрагментах
     */
    override fun onDestroy() {
        super.onDestroy()
        _viewBinding = null
    }
}