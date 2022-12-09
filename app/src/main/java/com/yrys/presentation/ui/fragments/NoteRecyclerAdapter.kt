package com.yrys.presentation.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yrys.domain.model.Note
import com.yrys.kotlin5group06lesson6multimodule.databinding.NotesBinding

class NoteRecyclerAdapter(
    private val onItemLongClick: (Note) -> Unit,
    private val onItemClick: (Note) -> Unit
) :
    ListAdapter<Note, NoteRecyclerAdapter.NoteViewHolder>(NoteDiffCallBack()) {

    inner class NoteViewHolder(private val binding: NotesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(note: Note) = with(binding) {
            tvTitle.text = note.title
            tvDescription.text = note.description
            itemView.setOnClickListener {
                onItemClick.invoke(getItem(absoluteAdapterPosition))
                return@setOnClickListener
            }
            itemView.setOnLongClickListener {
                onItemLongClick.invoke(getItem(absoluteAdapterPosition))
                return@setOnLongClickListener true
            }
        }

    }

    class NoteDiffCallBack : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            NotesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }


}