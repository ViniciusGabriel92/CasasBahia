package com.example.casasbahia.adapters

import android.content.Intent
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.casasbahia.MainActivity
import com.example.casasbahia.R
import com.example.core.domain.entity.commom.Product
import com.example.casasbahia.ui.detail.DetailActivity
import com.example.casasbahia.utils.Utils
import kotlinx.android.synthetic.main.product_item.view.*

class ProductAdapter(private val products: List<Product>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false);
        return ProductViewHolder(
            view
        );
    }

    override fun getItemCount(): Int {
        return products.size;
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ProductViewHolder -> {
                holder.bind(products.get(position))
            };
        };
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.item_name;
        val previous_price = itemView.item_previous_price;
        val current_price = itemView.item_current_price;
        var uriImage = itemView.item_image;

        fun bind(productItem: Product) {

            name.setText(productItem.Name);
            previous_price.setText(Utils.ConvertPrice(productItem.Price.PreviousPrice));
            current_price.setText(Utils.ConvertPrice(productItem.Price.CurrentPrice));
            val imageView: ImageView = itemView.findViewById(R.id.item_image);
            Glide.with(itemView.context)
                .asBitmap()
                .override(imageView.width, imageView.height)
                .load(productItem.ImageURI.replace("http", "https"))
                .error(R.drawable.ic_menu_camera)
                .into(imageView);

            previous_price.setPaintFlags(previous_price.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG);
            itemView.setOnClickListener(View.OnClickListener {
                val context = (itemView.context as MainActivity);
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("title", productItem.Name);
                (itemView.context as MainActivity).startActivity(intent);
            })
        }
    }
}

