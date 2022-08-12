package com.puzzle.industries.simplenotetakingapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.puzzle.industries.simplenotetakingapp.factory.CoroutineScopeFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

open class BaseViewModel : ViewModel() {

    private val coroutineScope
        get() = CoroutineScopeFactory.getScope(defaultScope = viewModelScope)

    protected fun runCoroutine(
        context: CoroutineContext = EmptyCoroutineContext,
        action: suspend CoroutineScope.() -> Unit
    ) = coroutineScope.launch(context) { action() }

    private fun <T> Flow<T>.collectFlow(
        action: suspend (value: T) -> Unit
    ): Job = coroutineScope.launch {
        collect {
            action(it)
        }
    }

}