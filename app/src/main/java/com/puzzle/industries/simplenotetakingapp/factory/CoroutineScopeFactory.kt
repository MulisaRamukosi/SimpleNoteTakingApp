package com.puzzle.industries.simplenotetakingapp.factory

import kotlinx.coroutines.CoroutineScope

object CoroutineScopeFactory {
    private var customScope: CoroutineScope? = null

    fun getScope(defaultScope: CoroutineScope) : CoroutineScope = customScope ?: defaultScope

}