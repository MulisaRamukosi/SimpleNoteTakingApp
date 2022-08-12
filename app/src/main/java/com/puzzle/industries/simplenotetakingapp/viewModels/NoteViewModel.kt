package com.puzzle.industries.simplenotetakingapp.viewModels

import com.puzzle.industries.domain.models.NoteDto
import com.puzzle.industries.domain.usecases.note.INoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import java.util.*
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val noteUseCase: INoteUseCase) : BaseViewModel() {

    private val _noteList = MutableStateFlow<List<NoteDto>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
        runCoroutine {

            noteUseCase.getAllNotesUseCase.getAllNotes()
                .distinctUntilChanged()
                .collect { listOfNotes ->
                    if (listOfNotes.isNotEmpty()) _noteList.value = listOfNotes
                }
        }
    }

    fun getNoteById(id: UUID) = noteList.value.firstOrNull { it.id == id }

    fun addNote(note: NoteDto) =
        runCoroutine { noteUseCase.createNoteUseCase.createNote(note = note) }

    fun deleteNote(note: NoteDto) =
        runCoroutine { noteUseCase.deleteNoteUseCase.deleteNote(note = note) }

    fun updateNote(newNote: NoteDto, oldNote: NoteDto) = runCoroutine {
        noteUseCase.updateNoteUseCase.updateNote(
            newNote = newNote,
            oldNote = oldNote
        )
    }
}