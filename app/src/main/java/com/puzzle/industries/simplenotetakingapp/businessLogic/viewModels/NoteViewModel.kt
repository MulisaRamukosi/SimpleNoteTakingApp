package com.puzzle.industries.simplenotetakingapp.businessLogic.viewModels

import com.puzzle.industries.simplenotetakingapp.businessLogic.repository.NoteRepository
import com.puzzle.industries.simplenotetakingapp.persistence.database.dto.NoteDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import java.util.*
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : BaseViewModel() {

    private val _noteList = MutableStateFlow<List<NoteDto>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
        runCoroutine {
            repository.getAllNotes()
                .distinctUntilChanged()
                .collect { listOfNotes ->
                    if (listOfNotes.isNotEmpty()) _noteList.value = listOfNotes
                }
        }
    }

    fun getNoteById(id: UUID) = noteList.value.firstOrNull { it.id == id }

    fun addNote(note: NoteDto) = runCoroutine { repository.addNote(note)  }

    fun deleteNote(note: NoteDto) = runCoroutine { repository.deleteNote(note) }

    fun updateNote(note: NoteDto) = runCoroutine { repository.updateNote(note) }
}