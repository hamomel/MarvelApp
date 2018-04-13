package com.example.roman_zotov.marvelapp.ui.character

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.roman_zotov.marvelapp.R
import kotlinx.android.synthetic.main.fragment_characters.view.*
import org.koin.android.architecture.ext.viewModel


/**
 * Created by Roman_Zotov on 02-Feb-18.
 */
class CharactersFragment : Fragment() {
    val viewModel: CharactersViewModel by viewModel()
    private lateinit var adapter: CharactersAdapter

    companion object {
        fun newInstance(): CharactersFragment {
            return CharactersFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_characters, container, false)
        adapter = CharactersAdapter()
        view.characters_recycler.adapter = adapter
        view.characters_recycler.layoutManager = GridLayoutManager(context, 2)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCharacters().observe(this, Observer { adapter.submitList(it) })
    }
}