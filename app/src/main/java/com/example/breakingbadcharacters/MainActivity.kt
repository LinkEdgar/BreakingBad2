package com.example.breakingbadcharacters

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CharacterViewModel
    private var recyclerView: RecyclerView? = null

    private var adapter: CharacterAdapter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(CharacterViewModel::class.java)
        setViews()
    }

    private fun setViews(){
        progress.visibility = View.VISIBLE
        recyclerView = recycler
        adapter = CharacterAdapter(this, ArrayList())
        recyclerView!!.adapter = adapter
        recyclerView!!.layoutManager = LinearLayoutManager(this)
    }

    override fun onStart() {
        super.onStart()
        viewModel.getCharacters().observe(this, Observer { response ->
            progress.visibility = View.GONE
            adapter!!.data.addAll(response)
            adapter!!.notifyDataSetChanged()
        })
    }
}