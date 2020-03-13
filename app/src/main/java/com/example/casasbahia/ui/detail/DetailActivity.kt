package com.example.casasbahia.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.casasbahia.R
import com.example.casasbahia.builders.BuilderDetailProduct
import com.example.infra.data.RepositoryDetailProduct

class DetailActivity : AppCompatActivity() {

    companion object {
        private val TAG = DetailActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        getIntent().getExtras()?.let {
            val title = it.getString("title");
            getSupportActionBar()?.let {
                setTitle(title);
            };
        };

        val parentLayout: ConstraintLayout = findViewById(R.id.dp_main_layout);
        var builderDetailProduct = BuilderDetailProduct(parentLayout, this.applicationContext);
        val serviceProduct = RepositoryDetailProduct();
        serviceProduct.getDetailProduct(builderDetailProduct);
    }
}