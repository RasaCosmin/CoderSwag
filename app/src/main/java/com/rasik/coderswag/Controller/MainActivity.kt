package com.rasik.coderswag.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import com.rasik.coderswag.Adapters.CategoryAdapter
import com.rasik.coderswag.Adapters.CategoryRecyclerAdapter
import com.rasik.coderswag.Model.Category
import com.rasik.coderswag.R
import com.rasik.coderswag.Services.DataService
import com.rasik.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : CategoryRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecyclerAdapter(this, DataService.categories) { category ->
            var intent = Intent(this, ProductActivity::class.java)
            intent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(intent)
        }

        categoryListView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)


    }
}
