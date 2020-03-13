package com.example.casasbahia.builders

import android.content.Context
import android.graphics.Paint
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.ViewPager
import com.example.casasbahia.LayoutFactory.FactoryMoreInformation
import com.example.casasbahia.LayoutFactory.LayoutFactory
import com.example.casasbahia.R
import com.example.casasbahia.adapters.ViewPagerAdapter
import com.example.casasbahia.ui.detail.DetailActivity
import com.example.casasbahia.utils.Utils
import com.example.core.domain.entity.commom.DetailProduct
import com.example.core.domain.entity.specific.ServiceProxy
import com.example.infra.data.RepositorySummaryProduct
import java.lang.reflect.Type

class BuilderDetailProduct(parentLayout: ConstraintLayout, applicationContext: Context) :
    ServiceProxy {

    lateinit var parentLayout: ConstraintLayout;
    lateinit var applicationContext: Context;
    internal lateinit var viewPager: ViewPager;

    init {
        this.parentLayout = parentLayout;
        this.applicationContext = applicationContext;
    }

    override fun onData(data: List<Type>) {
        val detailProduct = data.get(0) as DetailProduct;

        setDetail(detailProduct);
        val factory = LayoutFactory(FactoryMoreInformation());
        factory.InsertComponent(
            parentLayout,
            detailProduct.MoreInformartions as List<Type>
        );
        Log.e(TAG, "Detalhe do produto: " + data);

        var pb = Utils.GetProgressBar(parentLayout);
        if (pb != null)
            pb.visibility = if (detailProduct.Id > 0) View.INVISIBLE else View.VISIBLE;

        val parentLayout: ConstraintLayout = parentLayout.findViewById(R.id.dp_main_layout);
        var builderSummary = BuilderSummary(parentLayout);
        val serviceProduct = RepositorySummaryProduct();
        serviceProduct.getSummaryProduct(builderSummary);
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

    fun setDetail(detailProduct: DetailProduct) {
        viewPager = parentLayout.findViewById<View>(R.id.dp_view_pager) as ViewPager;
        val adapter = ViewPagerAdapter(parentLayout.context, detailProduct.Model.Pattern.Images);
        viewPager.adapter = adapter;

        var title: TextView = parentLayout.findViewById(R.id.dp_name);
        var description: TextView = parentLayout.findViewById(R.id.dp_description);
        var previousPrice: TextView = parentLayout.findViewById(R.id.dp_previous_price);
        var currentPrice: TextView = parentLayout.findViewById(R.id.dp_current_price);
        var paymentPlan: TextView = parentLayout.findViewById(R.id.dp_payment_plan);
        var moreInstallment: TextView = parentLayout.findViewById(R.id.dp_more_installment);
        var buttonBuy: TextView = parentLayout.findViewById(R.id.dp_btn_buy);
        buttonBuy.setOnClickListener(View.OnClickListener {
            Toast.makeText(parentLayout.context, "Compra realizada com sucesso!", Toast.LENGTH_LONG)
                .show();
        })

        val price = detailProduct.Model.Pattern.Prrice;

        title.setText(detailProduct.Name);
        description.setText(detailProduct.Description);
        previousPrice.setText(Utils.ConvertPrice(price.PreviousPrice));
        previousPrice.setPaintFlags(previousPrice.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG);
        currentPrice.setText(Utils.ConvertPrice(price.CurrentPrice));
        paymentPlan.setText(price.PaymentPlan);
        moreInstallment.setText(parentLayout.context.resources.getString(R.string.view_more_installment));

        //show and hide button and imageview
        val visibility = if (detailProduct.Id > 0) View.VISIBLE else View.INVISIBLE;
//        imageView.visibility = visibility
        buttonBuy.visibility = visibility

        //hide progressbar
        var pb: ProgressBar = parentLayout.findViewById(R.id.sharedProgressBar);
        if (pb != null)
            pb.visibility = if (detailProduct.Id > 0) View.INVISIBLE else View.VISIBLE;
    }

    companion object {
        private val TAG = DetailActivity::class.java.simpleName
    }
}