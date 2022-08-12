package com.puzzle.industries.data.repository

import com.puzzle.industries.data.database.dao.NoteDao
import com.puzzle.industries.data.mappers.NoteMapper
import com.puzzle.industries.domain.models.NoteDto
import com.puzzle.industries.domain.repositories.INoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

internal class NoteRepository @Inject constructor(
    private val noteDao: NoteDao,
    private val noteMapper: NoteMapper
) : INoteRepository {

    override suspend fun addNote(note: NoteDto) {
        noteDao.insert(noteMapper.toNoteEntity(note))
    }

    override suspend fun updateNote(note: NoteDto) {
        noteDao.update(noteMapper.toNoteEntity(note))
    }

    override suspend fun deleteNote(note: NoteDto) {
        noteDao.delete(noteMapper.toNoteEntity(note))
    }

    override fun getAllNotes(): Flow<List<NoteDto>> {
        return noteDao.getAllNotes().flowOn(
            context = Dispatchers.IO
        ).map {
            val notes = mutableListOf<NoteDto>()
            it.forEach{ noteEntity ->
                notes.add(noteMapper.toNoteDto(noteEntity))
            }
            return@map notes
        }.conflate()
    }
}