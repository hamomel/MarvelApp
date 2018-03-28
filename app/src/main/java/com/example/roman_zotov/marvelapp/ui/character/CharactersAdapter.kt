package com.example.roman_zotov.marvelapp.ui.character

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.roman_zotov.marvelapp.R
import com.example.roman_zotov.marvelapp.data.network.responces.Character
import com.squareup.picasso.Picasso

/**
 * Created by Roman_Zotov on 02-Feb-18.
 */
class CharactersAdapter : ListAdapter<Character, CharactersViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
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

    @BindView(R.id.character_iv)
    lateinit var photo: ImageView
    @BindView(R.id.character_name_tv)
    lateinit var name: TextView

    init {
        ButterKnife.bind(this, view)
    }

    fun bind(character: Character?) {
        if (character != null) {
            name.text = character.name
            val photoUrl = character.thumbnail?.url
            Picasso.with(context).load(photoUrl).fit().centerCrop().into(photo)
        }

    }
}
