package com.yrys.domain.usecase

import com.yrys.domain.repository.NoteRepository
import javax.inject.Inject

class GeAllNotesUseCase @Inject constructor(private val noteRepository: NoteRepository) {

    fun getAllNotes() = noteRepository.getAllNotes()

}