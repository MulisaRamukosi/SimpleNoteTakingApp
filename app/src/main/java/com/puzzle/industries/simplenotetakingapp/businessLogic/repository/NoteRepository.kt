package com.puzzle.industries.simplenotetakingapp.businessLogic.repository

import com.puzzle.industries.simplenotetakingapp.persistence.database.dao.NoteDao
import com.puzzle.industries.simplenotetakingapp.persistence.database.dto.NoteDto
import com.puzzle.industries.simplenotetakingapp.persistence.database.entities.NoteEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao){

    suspend fun addNote(note: NoteDto) = noteDao.insert(NoteEntity.toNoteEntity(note))
    suspend fun updateNote(note: NoteDto) = noteDao.update(NoteEntity.toNoteEntity(note))
    suspend fun deleteNote(note: NoteDto) = noteDao.delete(NoteEntity.toNoteEntity(note))
    fun getAllNotes(): Flow<List<NoteDto>> = noteDao.getAllNotes().flowOn(
        context = Dispatchers.IO
    ).map {
        val notes = mutableListOf<NoteDto>()
        it.forEach{ noteEntity ->
            notes.add(NoteEntity.toNoteDto(noteEntity))
        }
        return@map notes
    }.conflate()
}