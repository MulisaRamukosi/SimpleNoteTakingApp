package com.puzzle.industries.domain.usecases.note

interface INoteUseCase {

    val createNoteUseCase: ICreateNoteUseCase
    val deleteNoteUseCase: IDeleteNoteUseCase
    val updateNoteUseCase: IUpdateNoteUseCase
    val getAllNotesUseCase: IGetAllNotesUseCase

}