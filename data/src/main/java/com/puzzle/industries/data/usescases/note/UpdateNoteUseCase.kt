package com.puzzle.industries.data.usescases.note

import com.puzzle.industries.data.repository.NoteRepository
import com.puzzle.industries.domain.models.NoteDto
import com.puzzle.industries.domain.usecases.note.IUpdateNoteUseCase
import javax.inject.Inject

internal class UpdateNoteUseCase @Inject constructor(private val noteRepository: NoteRepository) :
    IUpdateNoteUseCase {

    override suspend fun updateNote(newNote: NoteDto, oldNote: NoteDto) {
        if (newNote.title != oldNote.title || newNote.description != oldNote.description) {
            newNote.id = oldNote.id
            noteRepository.updateNote(newNote)
        }
    }
}