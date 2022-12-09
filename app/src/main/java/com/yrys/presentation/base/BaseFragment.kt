package com.yrys.presentation.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.yrys.presentation.utils.UIState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseFragment(@LayoutRes private val layoutId: Int) : Fragment(layoutId) {

    protected fun <T> StateFlow<UIState<T>>.collectState(
        onError: (message: String) -> Unit,
        onSuccess: (data: T) -> Unit,
        state: ((UIState<T>) -> Unit)? = null
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                this@collectState.collect {
                    state?.invoke(it)
                    when (it) {
                        is UIState.Loading -> {}
                        is UIState.Error -> {
                            onError(it.error)
                        }
                        is UIState.Success -> {
                            if (it.data != null)
                                onSuccess(it.data)
                        }
                        is UIState.Empty -> {}
                    }
                }
            }
        }
    }
}