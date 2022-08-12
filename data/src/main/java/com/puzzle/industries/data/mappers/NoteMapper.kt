package com.puzzle.industries.data.mappers

import com.puzzle.industries.data.database.entity.NoteEntity
import com.puzzle.industries.domain.models.NoteDto


internal class NoteMapper{

    fun toNoteEntity(noteDto: NoteDto) : NoteEntity{
        return NoteEntity(
            id = noteDto.id,
            title = noteDto.title,
            description = noteDto.description,
            lastModifyDate = noteDto.lastModifyDate
        )
    }

    fun toNoteDto(noteEntity: NoteEntity) : NoteDto{
        return NoteDto(
            id = noteEntity.id,
            title = noteEntity.title,
            description = noteEntity.description,
            lastModifyDate = noteEntity.lastModifyDate
        )
    }
}
