package com.example.roman_zotov.marvelapp.ui.character

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.roman_zotov.marvelapp.R
import com.example.roman_zotov.marvelapp.data.network.responces.Character
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_character.view.*

/**
 * Created by Roman_Zotov on 02-Feb-18.
 */
class CharactersAdapter : PagedListAdapter<Character, CharactersViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_character, parent, false)
        return CharactersViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(oldItem: Character?, newItem: Character?) =
                    oldItem == newItem

            override fun areContentsTheSame(oldItem: Character?, newItem: Character?): Boolean =
                    oldItem?.equals(newItem) ?: false
        }
    }
}

class CharactersViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val context = view.context.applicationContext

    private val photo = view.character_iv
    private val name = view.character_name_tv
    private val description = view.character_description_tv

    fun bind(character: Character?) {
        if (character != null) {
            name.text = character.name
            description.text = character.description
            val photoUrl = character.thumbnail?.url
            setImage(photoUrl)
        } else {
            setImage(null)
        }
    }

    private fun setImage(url: String?) {
        Picasso.with(context)
                .load(url)
                .fit()
                .centerCrop()
                .placeholder(R.drawable.marvel_placeholder)
                .into(photo)
    }
}
