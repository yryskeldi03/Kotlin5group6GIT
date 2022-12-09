package com.yrys.presentation.ui.fragments.add_note

import com.yrys.domain.model.Note
import com.yrys.domain.usecase.AddNoteUseCase
import com.yrys.domain.usecase.EditNoteUseCase
import com.yrys.presentation.base.BaseViewModel
import com.yrys.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase,
    private val editNoteUseCase: EditNoteUseCase
) : BaseViewModel() {

    private val _addNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val addNoteState = _addNoteState.asStateFlow()

    private val _editNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val editNoteState = _editNoteState.asStateFlow()

    fun addNote(note: Note) {
        addNoteUseCase.addNote(note).collectData(_addNoteState)
    }

    fun editNote(note: Note) {
        editNoteUseCase.editNote(note).collectData(_editNoteState)
    }
}