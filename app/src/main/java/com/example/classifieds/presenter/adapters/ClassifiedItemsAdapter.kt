package com.example.classifieds.presenter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.classifieds.data.pojos.ClassifiedItem
import com.example.classifieds.databinding.ListItemClassifiedBinding
import com.example.classifieds.presenter.viewholders.ClassifiedItemsViewHolder
import com.example.classifieds.presenter.listeners.RecyclerItemClickListener

class ClassifiedItemsAdapter(
    private val classifiedList: ArrayList<ClassifiedItem>,
    private val recyclerItemClickListener: RecyclerItemClickListener
) : RecyclerView.Adapter<ClassifiedItemsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassifiedItemsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItemClassifiedBinding =
            ListItemClassifiedBinding.inflate(layoutInflater, parent, false)
        return ClassifiedItemsViewHolder(listItemClassifiedBinding)
    }

    override fun onBindViewHolder(holder: ClassifiedItemsViewHolder, position: Int) {
        holder.bind(classifiedList.get(position),recyclerItemClickListener)
    }

    override fun getItemCount(): Int {
        return classifiedList.size
    }
}