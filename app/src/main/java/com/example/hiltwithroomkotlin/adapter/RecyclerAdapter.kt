package com.example.hiltwithroomkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltwithroomkotlin.R
import com.example.hiltwithroomkotlin.model.RepositioryList
import com.example.hiltwithroomkotlin.model.RepositoryData
import kotlinx.android.synthetic.main.repositori_list.view.*

class RecyclerAdapter() :RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    private var listdata :List<RepositoryData>? = null

    fun setListData(listdata: List<RepositoryData>?){
        this.listdata = listdata
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.repositori_list,parent,false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
        holder.bind(listdata?.get(position)!!)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
        if (listdata == null)return 0
        return listdata?.size!!
    }

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        val txtdescription = view.txtdescription

        fun bind(data: RepositoryData){
            txtdescription.text = data.description
        }
    }
}