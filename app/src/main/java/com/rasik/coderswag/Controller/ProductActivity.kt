package com.rasik.coderswag.Controller

import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.rasik.coderswag.Adapters.ProductsAdapter
import com.rasik.coderswag.R
import com.rasik.coderswag.Services.DataService
import com.rasik.coderswag.Utilities.EXTRA_CATEGORY
import com.rasik.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {

    lateinit var adapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)

        val products = DataService.getProducts(categoryType)

        adapter = ProductsAdapter(this, products){product ->  
            val intent = Intent(this, ProductDetailsActivity::class.java)
            intent.putExtra(EXTRA_PRODUCT, product)
            startActivity(intent)
        }

        val orientation = resources.configuration.orientation
        var spanCount = 2

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3
        }

        val screenSize = resources.configuration.screenWidthDp
        if(screenSize > 720){
            spanCount = 3
        }

        productListView.adapter = adapter
        val layoutManager = GridLayoutManager(this, spanCount)
        productListView.layoutManager = layoutManager
    }
}
