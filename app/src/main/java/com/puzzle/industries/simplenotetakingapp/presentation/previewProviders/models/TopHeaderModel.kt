package com.puzzle.industries.simplenotetakingapp.presentation.previewProviders.models

import com.puzzle.industries.simplenotetakingapp.presentation.components.ActionButton

data class TopHeaderModel(
    val Title: String,
    val SubTitle: String,
    val IsHomeEnabled: Boolean,
    val actions: List<ActionButton> = emptyList()
)
