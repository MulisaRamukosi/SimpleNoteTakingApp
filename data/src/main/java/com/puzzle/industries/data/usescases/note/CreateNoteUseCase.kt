package com.puzzle.industries.data.usescases.note

import com.puzzle.industries.data.repository.NoteRepository
import com.puzzle.industries.domain.models.NoteDto
import com.puzzle.industries.domain.usecases.note.ICreateNoteUseCase
import javax.inject.Inject

internal class CreateNoteUseCase @Inject constructor(private val noteRepository: NoteRepository) : ICreateNoteUseCase {

    override suspend fun createNote(note: NoteDto) {
        if (note.title.isNotBlank() || note.description.isNotBlank()){
         noteRepository.addNote(note)
        }
    }
}