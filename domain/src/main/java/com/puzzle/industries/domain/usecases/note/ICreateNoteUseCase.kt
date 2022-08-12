package com.puzzle.industries.domain.usecases.note

import com.puzzle.industries.domain.models.NoteDto


interface ICreateNoteUseCase  {

    suspend fun createNote(note: NoteDto)

}