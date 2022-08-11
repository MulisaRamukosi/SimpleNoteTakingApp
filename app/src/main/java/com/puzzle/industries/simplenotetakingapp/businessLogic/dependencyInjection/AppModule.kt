package com.puzzle.industries.simplenotetakingapp.businessLogic.dependencyInjection

import android.content.Context
import com.puzzle.industries.simplenotetakingapp.persistence.database.AppDatabase
import com.puzzle.industries.simplenotetakingapp.persistence.database.dao.NoteDao
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
    fun provideNotesDao(database: AppDatabase) : NoteDao = database.noteDao()

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) : AppDatabase = AppDatabase.buildDatabase(context)
}