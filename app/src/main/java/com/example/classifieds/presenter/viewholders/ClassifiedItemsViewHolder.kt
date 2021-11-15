package com.example.classifieds.presenter.viewholders

import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.classifieds.data.pojos.ClassifiedItem
import com.example.classifieds.databinding.ListItemClassifiedBinding
import com.example.classifieds.presenter.listeners.RecyclerItemClickListener


class ClassifiedItemsViewHolder(private val listItemClassifiedBinding: ListItemClassifiedBinding) :
    RecyclerView.ViewHolder(listItemClassifiedBinding.root) {

    fun bind(classifiedItem: ClassifiedItem, recyclerItemClickListener: RecyclerItemClickListener) {

        listItemClassifiedBinding.name.text = classifiedItem.name
        listItemClassifiedBinding.price.text = "Price : " + classifiedItem.price

        listItemClassifiedBinding.container.setOnClickListener(View.OnClickListener {
            recyclerItemClickListener.itemClicked(adapterPosition)
        })

        var uri = Uri.parse(classifiedItem.image_urls.get(0))
        listItemClassifiedBinding.image.setImageURI(uri)

    }
}