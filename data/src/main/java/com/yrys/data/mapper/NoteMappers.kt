package com.yrys.data.mapper

import com.yrys.data.model.NoteEntity
import com.yrys.domain.model.Note

fun Note.toNoteEntity() = NoteEntity(
    id, title, description, createdAt
)

fun NoteEntity.toNote() = Note(
    id, title, description, createdAt
)