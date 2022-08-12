package com.puzzle.industries.data.database.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "note")
internal data class NoteEntity(
    @PrimaryKey
    val id: UUID,
    val title: String,
    val description: String,
    val lastModifyDate: Date = Date()
)