package com.example.casasbahia.builders

import android.util.Log
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.casasbahia.R
import com.example.casasbahia.adapters.ProductAdapter
import com.example.casasbahia.ui.product.ProductFragment
import com.example.casasbahia.utils.Utils
import com.example.core.domain.entity.commom.Product
import com.example.core.domain.entity.specific.ServiceProxy
import java.lang.reflect.Type

class BuilderProduct(
    parentLayout: ConstraintLayout,
    _products: MutableList<Product> = ArrayList(),
    productAdapter: ProductAdapter
) : ServiceProxy {
    private lateinit var productAdapter: ProductAdapter
    private var _products: MutableList<Product> = ArrayList()
    private var parentLayout: ConstraintLayout;

    init {
        this.productAdapter = productAdapter;
        this._products = _products;
        this.parentLayout = parentLayout;
    }

    override fun onData(data: List<Type>) {
        _products.addAll(data as List<Product>);
        productAdapter.notifyDataSetChanged();
        Log.e(TAG, "Total de produtos retornados: " + _products.size);

        var pb = Utils.GetProgressBar(parentLayout);
        if (pb != null)
            pb.visibility = if (_products.size > 0) View.INVISIBLE else View.VISIBLE;
    }

    override fun onFailed(t: Throwable) {
        Log.e(TAG, "Erro: " + t.localizedMessage);
        val modal = Utils.CreateAlertDialog(
            parentLayout.context,
            "Erro!",
            parentLayout.resources.getString(R.string.message_error)
        );
        modal.show();
        val pb = Utils.GetProgressBar(parentLayout);
        if (pb !== null)
            pb.visibility = View.INVISIBLE;
    }

    companion object {
        private val TAG = ProductFragment::class.java.simpleName
    }
}