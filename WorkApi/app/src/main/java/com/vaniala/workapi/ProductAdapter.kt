package com.vaniala.workapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vaniala.workapi.model.Product

class ProductAdapter(
    private val context: Context,
    private val productsList: List<Product>) :
    RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        )

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productsList[position]

        holder.productName.text = product.prName
        holder.productPrice.text = product.prPrice

        Glide.with(context).load(product.prImage).into(holder.productImage)
    }

    override fun getItemCount(): Int = productsList.size

}

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val productImage = itemView.findViewById<ImageView>(R.id.product_image)
    val productName = itemView.findViewById<TextView>(R.id.product_name)
    val productPrice = itemView.findViewById<TextView>(R.id.product_price)
}