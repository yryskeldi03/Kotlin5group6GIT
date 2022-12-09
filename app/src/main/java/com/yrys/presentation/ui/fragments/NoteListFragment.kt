package com.yrys.presentation.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.yrys.domain.model.Note
import com.yrys.kotlin5group06lesson6multimodule.R
import com.yrys.kotlin5group06lesson6multimodule.databinding.FragmentNoteListBinding
import com.yrys.presentation.base.BaseFragment
import com.yrys.presentation.utils.UIState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteListFragment : BaseFragment(R.layout.fragment_note_list) {

    private val noteAdapter by lazy { NoteAdapter(this::onItemLongClick, this::onItemClick) }
    private val notesAdapter by lazy {
        NoteRecyclerAdapter(
            this::onItemLongClick,
            this::onItemClick
        )
    }
    private val viewModel by viewModels<NoteListViewModel>()
    private val binding by viewBinding(FragmentNoteListBinding::bind)
    private val a = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupRequest()
        setupObservers()
        setupClickListeners()
    }

    private fun initialize() = with(binding) {
        rvNotes.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rvNotes.adapter = noteAdapter
    }

    private fun setupRequest() {
        viewModel.getAllNotes()
    }

    private fun setupObservers() {
        viewModel.getAllNotesState.collectState(
            state = { state ->
                binding.progressBar.isVisible = state is UIState.Loading
                binding.rvNotes.isVisible = state !is UIState.Loading
            },
            onError = {
            },
            onSuccess = { data ->
//                notesAdapter.submitList(data)
                noteAdapter.setData(data)
                Toast.makeText(requireContext(), "Notes updated successfully", Toast.LENGTH_SHORT)
                    .show()
            }
        )
        viewModel.deleteNoteState.collectState(
            onError = { },
            onSuccess = {
                Toast.makeText(requireContext(), "Deleted Successfully", Toast.LENGTH_SHORT).show()
            }
        )
    }

    private fun setupClickListeners() {
        binding.btnFab.setOnClickListener {
            findNavController().navigate(R.id.addNoteFragment)
        }
    }

    private fun onItemLongClick(note: Note) {
        viewModel.deleteNote(note)
        noteAdapter.delete(note)
    }

    private fun onItemClick(note: Note) {
        val bundle = Bundle()
        bundle.putSerializable(ARG_EDIT_NOTE, note)
        findNavController().navigate(R.id.addNoteFragment, bundle)
    }

    companion object {
        const val ARG_EDIT_NOTE = "edit_note"
    }
}