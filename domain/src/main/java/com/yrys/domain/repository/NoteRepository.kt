package com.yrys.domain.repository

import com.yrys.domain.model.Note
import com.yrys.domain.utils.Resource
import kotlinx.coroutines.flow.Flow


interface NoteRepository {

    fun addNote(note: Note): Flow<Resource<Unit>>

    fun deleteNote(note: Note): Flow<Resource<Unit>>

    fun editNote(note: Note): Flow<Resource<Unit>>

    fun getAllNotes(): Flow<Resource<List<Note>>>
}