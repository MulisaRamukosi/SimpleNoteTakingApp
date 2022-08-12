package com.puzzle.industries.domain.usecases.note

import com.puzzle.industries.domain.models.NoteDto

interface IDeleteNoteUseCase {
    suspend fun deleteNote(note: NoteDto)
}