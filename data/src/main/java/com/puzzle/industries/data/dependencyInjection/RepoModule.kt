package com.puzzle.industries.data.dependencyInjection

import com.puzzle.industries.data.database.dao.NoteDao
import com.puzzle.industries.data.mappers.NoteMapper
import com.puzzle.industries.data.repository.NoteRepository
import com.puzzle.industries.domain.repositories.INoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class RepoModule {

    @Singleton
    @Provides
    fun provideNoteRepo(noteMapper: NoteMapper, noteDao: NoteDao): INoteRepository =
        NoteRepository(noteMapper = noteMapper, noteDao = noteDao)

}