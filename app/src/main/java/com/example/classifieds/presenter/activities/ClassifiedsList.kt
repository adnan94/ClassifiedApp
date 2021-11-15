package com.example.classifieds.presenter.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.classifieds.R
import android.widget.ViewAnimator
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.classifieds.data.pojos.ClassifiedItem
import com.example.classifieds.databinding.ActivityClassifiedsBinding
import androidx.lifecycle.ViewModelProviders
import com.example.classifieds.data.viewmodels.ClassifiedsViewModel
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.example.classifieds.presenter.adapters.ClassifiedItemsAdapter
import com.example.classifieds.presenter.listeners.OnSucessListener
import com.example.classifieds.presenter.listeners.RecyclerItemClickListener


class ClassifiedsList : AppCompatActivity(), RecyclerItemClickListener {

    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var binding: ActivityClassifiedsBinding
    lateinit var classifiedItemsAdapter: ClassifiedItemsAdapter
    lateinit var classifiedsViewModel: ClassifiedsViewModel
    lateinit var progressBar: ProgressBar
    var classifiedList = ArrayList<ClassifiedItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_classifieds)
        classifiedsViewModel = ViewModelProviders.of(this).get(ClassifiedsViewModel::class.java)
        buildProgressBar()
        setAdapter()
        getClassifiedList()
    }

    private fun buildProgressBar() {
        val layout: ConstraintLayout = findViewById(R.id.root)
        progressBar = ProgressBar(this, null, android.R.attr.progressBarStyleLarge)
        val params = ConstraintLayout.LayoutParams(100, 100)
        params.bottomToBottom = ConstraintSet.PARENT_ID;
        params.endToEnd = ConstraintSet.PARENT_ID;
        params.startToStart = ConstraintSet.PARENT_ID;
        params.topToTop = ConstraintSet.PARENT_ID;
        layout.addView(progressBar, params)
        showProgressBar()
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    private fun getClassifiedList() {
        classifiedsViewModel.getClassifiedList(object : OnSucessListener {
            override fun onSucess(list: List<ClassifiedItem>) {
                classifiedList.addAll(list)
                classifiedItemsAdapter.notifyDataSetChanged()
                hideProgressBar()
            }
        })

    }

    private fun setAdapter() {
        linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.classifiedList.setLayoutManager(linearLayoutManager)
        classifiedItemsAdapter = ClassifiedItemsAdapter(classifiedList, this)
        binding.classifiedList.setAdapter(classifiedItemsAdapter)
        binding.classifiedList.visibility = ViewAnimator.VISIBLE
    }


    override fun itemClicked(position: Int) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("item", classifiedList.get(position))
        startActivity(intent)
    }
}