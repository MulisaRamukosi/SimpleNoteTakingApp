package com.puzzle.industries.simplenotetakingapp.persistence.database.dao

import androidx.room.*
import com.puzzle.industries.simplenotetakingapp.persistence.database.entities.NoteEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDao {

    @Query("select * from note")
    fun getAllNotes() : Flow<List<NoteEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: NoteEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: NoteEntity)

    @Delete
    suspend fun delete(note: NoteEntity)
}