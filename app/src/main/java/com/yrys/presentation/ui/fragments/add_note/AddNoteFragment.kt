package com.yrys.presentation.ui.fragments.add_note

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.yrys.domain.model.Note
import com.yrys.kotlin5group06lesson6multimodule.R
import com.yrys.kotlin5group06lesson6multimodule.databinding.FragmentAddNoteBinding
import com.yrys.presentation.base.BaseFragment
import com.yrys.presentation.utils.showToast
import com.yrys.presentation.ui.fragments.NoteListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteFragment : BaseFragment(R.layout.fragment_add_note) {

    private val binding by viewBinding(FragmentAddNoteBinding::bind)
    private val viewModel by viewModels<AddNoteViewModel>()
    private var editableNote: Note? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupRequest()
        setupObservers()
        setupClickListeners()
    }

    private fun initialize() {
        editableNote =
            arguments?.getSerializable(NoteListFragment.ARG_EDIT_NOTE) as Note?
        if (editableNote != null) {
            binding.etTitle.setText(editableNote!!.title)
            binding.etDesciption.setText(editableNote!!.description)
        }
    }

    private fun setupRequest() {
    }

    private fun setupObservers() {
        viewModel.addNoteState.collectState(
            onError = {

            },
            onSuccess = {
                findNavController().navigateUp()
            }
        )

        viewModel.editNoteState.collectState(

            onError = {
                showToast(it)
            },
            onSuccess = {
                findNavController().navigateUp()
            }
        )
    }

    private fun setupClickListeners() = with(binding) {
        btnSave.setOnClickListener {
            if (editableNote != null) {
                val note = Note(
                    id = editableNote!!.id,
                    title = etTitle.text.toString(),
                    description = etDesciption.text.toString(),
                    createdAt = System.currentTimeMillis()
                )
                viewModel.editNote(note)
            } else {
                viewModel.addNote(
                    Note(
                        title = etTitle.text.toString(),
                        description = etDesciption.text.toString(),
                        createdAt = System.currentTimeMillis()
                    )
                )
            }
        }
    }
}