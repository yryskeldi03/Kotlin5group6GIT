package com.yrys.data.repository

import com.yrys.data.base.BaseRepository
import com.yrys.data.local.NoteDao
import com.yrys.data.mapper.toNote
import com.yrys.data.mapper.toNoteEntity
import com.yrys.domain.model.Note
import com.yrys.domain.repository.NoteRepository
import com.yrys.domain.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
) : NoteRepository, BaseRepository() {

    //We can do with return type
    override fun addNote(note: Note): Flow<Resource<Unit>> = doRequest {
        noteDao.addNote(note.toNoteEntity())
    }

    //Also we can do without return type
    override fun deleteNote(note: Note) = doRequest {
        delay(2000)
        noteDao.deleteNote(note.toNoteEntity())
    }

    override fun editNote(note: Note): Flow<Resource<Unit>> = doRequest {
        noteDao.editNote(note.toNoteEntity())
    }

    override fun getAllNotes(): Flow<Resource<List<Note>>> = flow {
        emit(Resource.Loading(data = null))
        delay(5000)
        try {
            val data = noteDao.gAllNotes().map { it.toNote() }
            emit(Resource.Success(data))
        } catch (ioException: IOException) {
            emit(Resource.Error(ioException.localizedMessage ?: "Unknown error"))
        }
    }
}