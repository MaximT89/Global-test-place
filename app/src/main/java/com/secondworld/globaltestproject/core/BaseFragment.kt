package com.secondworld.globaltestproject.core

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.secondworld.globaltestproject.R
import com.secondworld.globaltestproject.databinding.CustomAlertDialogBinding

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

/**
 * Базовый фрагмент, наследуемся от него у всех фрагментов, данная база уменьшает шаблонный код,
 * в данной базе мы сразу получаем биндинг и переопределяем метод на присваивание viewModel
 */
abstract class BaseFragment<B : ViewBinding, VM : ViewModel>(private val inflate: Inflate<B>) :
    Fragment() {

    private var _viewBinding: B? = null
    protected val binding get() = checkNotNull(_viewBinding)
    protected abstract val viewModel: VM
    protected var toolbar: Toolbar? = null

    open val showBtnAddUser = false

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

    @SuppressLint("InflateParams")
    fun alertDialog(
        positiveBtnLogic: () -> Unit = {},
        negativeBtnLogic: () -> Unit = {},
        titleAlert: String,
        bodyText: String
    ) {
        val dialogViewBinding =
            CustomAlertDialogBinding.inflate(LayoutInflater.from(requireActivity())).apply {
                title.text = titleAlert
                body.text = bodyText
            }

        val dialog =
            AlertDialog.Builder(requireActivity(), R.style.AlertDialog_Custom).create().apply {
                setView(dialogViewBinding.root)
                show()
            }

        dialogViewBinding.btnPositive.click {
            positiveBtnLogic.invoke()
            dialog.dismiss()
        }

        dialogViewBinding.btnNegative.click {
            negativeBtnLogic.invoke()
            dialog.dismiss()
        }
    }

    /**
     * Если нужно отобразить Snackbar, то его всегда можно получить из базового фрагмента.
     * @param view нужно вставить binding.root.
     * @param message сообщение которое вы хотите отобразить в snackbar.
     */
    @SuppressLint("InflateParams")
    fun showSnackbar(
        message: String,
        type: SnackbarType = SnackbarType.SIMPLE,
        colorBg: Int? = null
    ) {
        val snackbar = Snackbar.make(requireActivity(), binding.root, message, Snackbar.LENGTH_LONG)

        fun snackbarSetBg(snackbar: Snackbar, colorBg: Int?, defaultColor: Int) {
            snackbar.setBackgroundTint(
                ContextCompat.getColor(
                    requireActivity(),
                    if (colorBg == null) defaultColor
                    else {
                        try { colorBg }
                        catch (e: Exception) { defaultColor }
                    }
                )
            )
        }

        when (type) {
            SnackbarType.SIMPLE -> {
                if (colorBg != null) {
                    try {
                        snackbar.setBackgroundTint(
                            ContextCompat.getColor(
                                requireActivity(),
                                colorBg
                            )
                        )
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
            SnackbarType.POSITIVE -> snackbarSetBg(snackbar, colorBg, R.color.green)
            SnackbarType.NEGATIVE -> snackbarSetBg(snackbar, colorBg, R.color.indian_red)
        }

        snackbar.show()
    }

    enum class SnackbarType {
        SIMPLE,
        POSITIVE,
        NEGATIVE
    }

    /**
     * Функция копирования в буфер обмена
     */
    fun clipToBuffer(str: String) {
        val clipboard =
            requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
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