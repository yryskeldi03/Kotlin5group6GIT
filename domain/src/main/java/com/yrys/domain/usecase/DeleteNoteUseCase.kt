package com.yrys.domain.usecase

import com.yrys.domain.model.Note
import com.yrys.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(private val noteRepository: NoteRepository) {

    fun deleteNote(note: Note) = noteRepository.deleteNote(note)
}