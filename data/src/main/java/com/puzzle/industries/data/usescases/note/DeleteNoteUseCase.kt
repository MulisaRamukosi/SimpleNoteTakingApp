package com.puzzle.industries.data.usescases.note

import com.puzzle.industries.data.repository.NoteRepository
import com.puzzle.industries.domain.models.NoteDto
import com.puzzle.industries.domain.usecases.note.IDeleteNoteUseCase
import javax.inject.Inject

internal class DeleteNoteUseCase @Inject constructor(private val noteRepository: NoteRepository) : IDeleteNoteUseCase{

    override suspend fun deleteNote(note: NoteDto) {
        noteRepository.deleteNote(note)
    }

}