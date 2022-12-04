package com.secondworld.globaltestproject.core

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.StringRes
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import java.lang.IllegalArgumentException

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

/**
 * Базовый фрагмент, наследуемся от него у всех фрагментов, данная база уменьшает шаблонный код,
 * в данной базе мы сразу получаем биндинг и переопределяем метод на присваивание viewModel
 */
abstract class BaseFragment<B : ViewBinding>(private val inflate: Inflate<B>) :
    Fragment(), Navigator {

    private var _viewBinding: B? = null
    protected val binding get() = checkNotNull(_viewBinding)
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

    open fun customBackPressed(
        needCustomNavigate: Boolean = false,
        resId: Int? = null
    ) {
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {

                override fun handleOnBackPressed() {
                    if (needCustomNavigate) if(resId != null) findNavController().navigate(resId)
                    else {
                        if (isEnabled) isEnabled = false
                    }
                }
            })
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
    override fun navigateTo(resId: Int, args: Bundle?, navOptions: NavOptions?) =
        findNavController().navigate(resId, args, navOptions)

    override fun navigateTo(resId: Int, args: Bundle?) = findNavController().navigate(resId, args)

    override fun navigateTo(resId: Int) = findNavController().navigate(resId)

    override fun navigateUp() {
        findNavController().navigateUp()
    }

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