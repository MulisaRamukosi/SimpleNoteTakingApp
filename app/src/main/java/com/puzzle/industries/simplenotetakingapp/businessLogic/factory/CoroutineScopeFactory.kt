package com.puzzle.industries.simplenotetakingapp.businessLogic.factory

import kotlinx.coroutines.CoroutineScope

object CoroutineScopeFactory {
    private var customScope: CoroutineScope? = null

    fun getScope(defaultScope: CoroutineScope) : CoroutineScope = customScope ?: defaultScope

}