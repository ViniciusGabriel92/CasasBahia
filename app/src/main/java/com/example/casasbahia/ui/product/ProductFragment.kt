package com.example.casasbahia.ui.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.casasbahia.R
import com.example.casasbahia.adapters.ProductAdapter
import com.example.casasbahia.builders.BuilderProduct
import com.example.core.domain.entity.commom.Product
import com.example.infra.data.RepositoryProduct

class ProductFragment : Fragment() {

    private lateinit var productAdapter: ProductAdapter
    private var _products: MutableList<Product> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_product, container, false)
        initRecyclerView(root);
        var builderProduct = BuilderProduct(root.findViewById(R.id.fragment_product), _products, productAdapter);
        val serviceProduct = RepositoryProduct();
        serviceProduct.getProducts(builderProduct);

        return root
    }

    private fun initRecyclerView(root: View) {
        val recyclerView: RecyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.apply {
            layoutManager = GridLayoutManager(this@ProductFragment.context, 2)
            productAdapter =
                ProductAdapter(_products)
            adapter = productAdapter
        }
    }
}



