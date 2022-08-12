package com.puzzle.industries.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.puzzle.industries.data.database.dao.NoteDao
import com.puzzle.industries.data.database.entity.NoteEntity
import com.puzzle.industries.data.database.typeConverters.DateConverter

@Database(
    entities = [NoteEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    DateConverter::class
)
internal abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        private const val DB_NAME = "note-taking-db"
        fun buildDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME).build()
    }
}