package com.puzzle.industries.simplenotetakingapp.persistence.database.dto

import java.util.*

data class NoteDto (
    var id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    var lastModifyDate: Date = Date()
)