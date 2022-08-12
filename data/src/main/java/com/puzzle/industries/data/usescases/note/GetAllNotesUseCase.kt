package com.puzzle.industries.data.usescases.note

import com.puzzle.industries.data.repository.NoteRepository
import com.puzzle.industries.domain.models.NoteDto
import com.puzzle.industries.domain.usecases.note.IGetAllNotesUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class GetAllNotesUseCase @Inject constructor(private val noteRepository: NoteRepository) : IGetAllNotesUseCase {

    override suspend fun getAllNotes(): Flow<List<NoteDto>> {
        return noteRepository.getAllNotes()
    }

}