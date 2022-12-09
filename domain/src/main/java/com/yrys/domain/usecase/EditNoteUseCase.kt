package com.yrys.domain.usecase

import com.yrys.domain.model.Note
import com.yrys.domain.repository.NoteRepository
import javax.inject.Inject

class EditNoteUseCase @Inject constructor(private val noteRepository: NoteRepository) {

    fun editNote(note: Note) = noteRepository.editNote(note)
}