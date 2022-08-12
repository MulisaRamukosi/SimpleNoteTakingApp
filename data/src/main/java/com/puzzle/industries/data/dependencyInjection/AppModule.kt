package com.puzzle.industries.data.dependencyInjection

import android.content.Context
import com.puzzle.industries.data.database.AppDatabase
import com.puzzle.industries.data.database.dao.NoteDao
import com.puzzle.industries.data.mappers.NoteMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun providesNoteMapper(): NoteMapper = NoteMapper()

    @Singleton
    @Provides
    fun provideNotesDao(database: AppDatabase) : NoteDao = database.noteDao()

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) : AppDatabase = AppDatabase.buildDatabase(context)
}