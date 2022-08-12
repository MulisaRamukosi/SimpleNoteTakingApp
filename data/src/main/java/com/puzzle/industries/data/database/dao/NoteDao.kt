package com.puzzle.industries.data.database.dao

import androidx.room.*
import com.puzzle.industries.data.database.entity.NoteEntity
import kotlinx.coroutines.flow.Flow


@Dao
internal interface NoteDao {

    @Query("select * from note")
    fun getAllNotes() : Flow<List<NoteEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: NoteEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: NoteEntity)

    @Delete
    suspend fun delete(note: NoteEntity)
}