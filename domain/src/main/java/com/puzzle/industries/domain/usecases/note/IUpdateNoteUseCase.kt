package com.puzzle.industries.domain.usecases.note

import com.puzzle.industries.domain.models.NoteDto

interface IUpdateNoteUseCase {

    suspend fun updateNote(newNote: NoteDto, oldNote: NoteDto)

}