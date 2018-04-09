package com.example.roman_zotov.marvelapp.ui.character

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.roman_zotov.marvelapp.R
import kotlinx.android.synthetic.main.fragment_characters.*


/**
 * Created by Roman_Zotov on 02-Feb-18.
 */
class CharactersFragment : Fragment() {
    private lateinit var viewModel: CharactersViewModel
    private lateinit var adapter: CharactersAdapter

    companion object {
        fun newInstance(): CharactersFragment {
            return CharactersFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CharactersViewModel::class.java)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_characters, container, false)
        adapter = CharactersAdapter()
        characters_recycler.adapter = adapter
        characters_recycler.layoutManager = GridLayoutManager(context, 2)
        viewModel.getCharacters().observe(this, Observer { adapter.submitList(it) })
        return view
    }
}