package com.puzzle.industries.domain.repositories

import com.puzzle.industries.domain.models.NoteDto
import kotlinx.coroutines.flow.Flow

interface INoteRepository {

    suspend fun addNote(note: NoteDto)

    suspend fun updateNote(note: NoteDto)

    suspend fun deleteNote(note: NoteDto)

    fun getAllNotes(): Flow<List<NoteDto>>

}