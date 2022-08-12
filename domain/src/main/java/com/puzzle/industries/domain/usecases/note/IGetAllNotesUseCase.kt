package com.puzzle.industries.domain.usecases.note

import com.puzzle.industries.domain.models.NoteDto
import kotlinx.coroutines.flow.Flow

interface IGetAllNotesUseCase {

    suspend fun getAllNotes(): Flow<List<NoteDto>>

}