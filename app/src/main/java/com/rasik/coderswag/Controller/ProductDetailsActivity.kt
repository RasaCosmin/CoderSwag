package com.rasik.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.rasik.coderswag.Model.Product
import com.rasik.coderswag.R
import com.rasik.coderswag.Utilities.EXTRA_CATEGORY
import com.rasik.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product_details_activity.*

class ProductDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details_activity)

        val product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)

        val resourceId = resources.getIdentifier(product.image,
                "drawable",
                packageName)
        image.setImageResource(resourceId)

        name.text = product.title
        price.text = product.price

        description.text = "The first thing I would do, is make the Product class Parcelable. We covered this in the previous section. Pretty easy to do, all you need to do is extend the Parcelable interface, the do alt+enter and select ‘add Parcelable implementation’. The class needs to be parcel able so that we can pass the product object from the ProductsActivity to the new ProductDetailActivity"

    }
}
