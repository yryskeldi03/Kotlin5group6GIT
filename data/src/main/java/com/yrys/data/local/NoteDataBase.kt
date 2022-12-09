package com.yrys.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yrys.data.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
abstract class NoteDataBase : RoomDatabase() {

    abstract fun noteDao(): NoteDao
}