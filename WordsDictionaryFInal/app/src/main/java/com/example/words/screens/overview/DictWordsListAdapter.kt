package com.example.words.screens.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.words.databinding.DictWordItemBinding
import com.example.words.entity.Word
import com.example.words.screens.overview.DictWordsListAdapter

class DictWordsListAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Word, DictWordsListAdapter.WordViewHolder>(DiffCallback) {
    class WordViewHolder(
        private var binding: DictWordItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(word: Word) {
            binding.word = word
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder(DictWordItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(word)
        }
        holder.bind(word)
    }



    companion object DiffCallback : DiffUtil.ItemCallback<Word>() {
        override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem.id == newItem.id
        }
    }


    class OnClickListener(val clickListener: (word: Word) -> Unit) {
        fun onClick(word: Word) = clickListener(word)
    }

}