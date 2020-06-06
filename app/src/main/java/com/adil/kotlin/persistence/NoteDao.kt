package com.adil.kotlin.persistence

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note): Long

    @Update
    fun update(note: Note)

    @Query("delete from tbl_note where id = :id")
    fun deleteById(id: Int)

    @Delete
    fun delete(note: Note)

    @Query("select * from tbl_note")
    fun getAllNotes(): LiveData<List<Note>>
}