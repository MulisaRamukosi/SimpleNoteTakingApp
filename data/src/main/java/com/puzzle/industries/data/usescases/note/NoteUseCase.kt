package com.puzzle.industries.data.usescases.note

import com.puzzle.industries.data.repository.NoteRepository
import com.puzzle.industries.domain.usecases.note.*
import javax.inject.Inject

internal class NoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
): INoteUseCase {

    override val createNoteUseCase: ICreateNoteUseCase
        get() = CreateNoteUseCase(noteRepository)

    override val deleteNoteUseCase: IDeleteNoteUseCase
        get() = DeleteNoteUseCase(noteRepository)

    override val updateNoteUseCase: IUpdateNoteUseCase
        get() = UpdateNoteUseCase(noteRepository)

    override val getAllNotesUseCase: IGetAllNotesUseCase
        get() = GetAllNotesUseCase(noteRepository)
}