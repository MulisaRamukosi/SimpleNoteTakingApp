package com.puzzle.industries.data.dependencyInjection

import com.puzzle.industries.data.repository.NoteRepository
import com.puzzle.industries.data.usescases.note.NoteUseCase
import com.puzzle.industries.domain.usecases.note.INoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class UseCaseModule {

    @Singleton
    @Provides
    fun provideNoteUseCase(noteRepository: NoteRepository) : INoteUseCase = NoteUseCase(noteRepository)

}