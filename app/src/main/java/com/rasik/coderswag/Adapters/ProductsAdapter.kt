package com.rasik.coderswag.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.rasik.coderswag.Model.Product
import com.rasik.coderswag.R

/**
 * Created by Rasa Cosmin on 05.04.2018.
 */
class ProductsAdapter(val context: Context, val products: List<Product>, val itemClick: (Product) -> Unit) : RecyclerView.Adapter<ProductsAdapter.ProductHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_list_item, parent, false)
        return ProductHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bindProduct(context, products[position])
    }

    inner class ProductHolder(itemView: View?, itemClick: (Product) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val productImage = itemView?.findViewById<ImageView>(R.id.product_image)
        val productName = itemView?.findViewById<TextView>(R.id.product_name)
        val productPrice = itemView?.findViewById<TextView>(R.id.product_price)

        fun bindProduct(context: Context, product: Product) {

            productName?.text = product.title
            val resourceId = context.resources.getIdentifier(product.image,
                    "drawable",
                    context.packageName)
            productImage?.setImageResource(resourceId)
            productPrice?.text = product.price

            itemView.setOnClickListener { itemClick(product) }
        }
    }
}