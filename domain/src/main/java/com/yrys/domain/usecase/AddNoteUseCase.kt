package com.yrys.domain.usecase

import com.yrys.domain.model.Note
import com.yrys.domain.repository.NoteRepository
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(private val noteRepository: NoteRepository) {

    fun addNote(note: Note) = noteRepository.addNote(note)
}