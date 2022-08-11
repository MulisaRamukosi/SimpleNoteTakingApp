package com.puzzle.industries.simplenotetakingapp.persistence.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.puzzle.industries.simplenotetakingapp.persistence.database.dto.NoteDto
import java.util.*

@Entity(tableName = "note")
data class NoteEntity(
    @PrimaryKey
    val id: UUID,
    val title: String,
    val description: String,
    val lastModifyDate: Date = Date()
){
    companion object{
        fun toNoteEntity(noteDto: NoteDto) : NoteEntity{
            return NoteEntity(
                id = noteDto.id,
                title = noteDto.title,
                description = noteDto.description,
                lastModifyDate = noteDto.lastModifyDate
            )
        }

        fun toNoteDto(noteEntity: NoteEntity) : NoteDto {
            return NoteDto(
                id = noteEntity.id,
                title = noteEntity.title,
                description = noteEntity.description,
                lastModifyDate = noteEntity.lastModifyDate
            )
        }
    }
}