package com.yrys.presentation.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yrys.domain.model.Note
import com.yrys.kotlin5group06lesson6multimodule.databinding.NotesBinding

class NoteAdapter(
    private val onItemLongClick: (Note) -> Unit,
    private val onItemClick: (Note) -> Unit
) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    private var mlist = mutableListOf<Note>()

    fun setData(list: List<Note>) {
        mlist.clear()
        mlist.addAll(list)
        notifyDataSetChanged()
    }


    inner class ViewHolder(private val binding: NotesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(note: Note) = with(binding) {
            tvTitle.text = note.title
            tvDescription.text = note.description
            itemView.setOnLongClickListener {
                onItemLongClick.invoke(note)
                return@setOnLongClickListener true
            }
            itemView.setOnClickListener {
                onItemClick.invoke(note)
                return@setOnClickListener
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            NotesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(mlist[position])
    }

    override fun getItemCount(): Int {
        return mlist.size
    }

    fun delete(note: Note) {
        val position = mlist.indexOf(note)
        mlist.removeAt(position)
        notifyItemRemoved(position)
    }

    fun edit(note: Note) {
        val position = mlist.indexOfFirst { it.createdAt == note.createdAt }
        mlist[position] = note
        notifyItemChanged(position)
    }

}