package com.example.roman_zotov.marvelapp.ui.character

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
class CharactersAdapter : RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>() {
    private var characters: List<Character>? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CharactersViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_character, parent, false)
        return CharactersViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharactersViewHolder?, position: Int) {
        holder?.bind(characters!!.get(position))
    }

    override fun getItemCount() = characters?.size ?: 0

    class CharactersViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val context = view.context

        fun bind(character: Character) {
            itemView.character_name_tv.text = character.name
            val photoUrl = character.thumbnail?.url
            Picasso.with(context).load(photoUrl).fit().centerCrop().into(itemView.character_iv)
        }
    }

    fun setCharacters(characters: List<Character>?) {
        this.characters = characters
        notifyDataSetChanged()
    }
}