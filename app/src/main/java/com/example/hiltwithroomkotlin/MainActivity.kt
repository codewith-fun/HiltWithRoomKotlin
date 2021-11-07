package com.example.hiltwithroomkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hiltwithroomkotlin.adapter.RecyclerAdapter
import com.example.hiltwithroomkotlin.model.RepositoryData
import com.example.hiltwithroomkotlin.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var recyclerAdapter:RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        initMainModel()
    }

    private fun initViewModel(){
        recycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration = DividerItemDecoration(applicationContext,DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            recyclerAdapter = RecyclerAdapter()
            adapter = recyclerAdapter
        }
    }

    private fun initMainModel(){
        val viewmodel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewmodel.getAllRepositoriesList().observe(this, Observer {
            recyclerAdapter.setListData(it)
            recyclerAdapter.notifyDataSetChanged()
        })
        viewmodel.makeApiCall()
    }
}