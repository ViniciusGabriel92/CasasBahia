package com.example.casasbahia.LayoutFactory

import android.graphics.Paint
import android.graphics.Typeface
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.casasbahia.R
import com.example.core.domain.entity.commom.SummaryProduct
import com.example.casasbahia.utils.Utils
import java.lang.reflect.Type

class FactorySummaryProduct : ILayoutFactory {
    override fun InsertComponent(parentLayout: ConstraintLayout, objectsComponent: List<Type>) {
        val listSummaryProduct = objectsComponent as List<SummaryProduct>;
        if (listSummaryProduct.size > 0)
            insertSummary(parentLayout, listSummaryProduct);
    }

    fun insertSummary(
        parentLayout: ConstraintLayout,
        summaryProducts: List<SummaryProduct>
    ) {

        var idLastChildInfo = parentLayout.getChildAt(parentLayout.childCount - 1).id;
        val dynamicTitleSummary = TextView(parentLayout.context);
        val paramsSummary = ConstraintLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        paramsSummary.setMargins(0, 40, 0, 0);
        dynamicTitleSummary.setTypeface(Typeface.DEFAULT_BOLD);
        dynamicTitleSummary.layoutParams = paramsSummary;
        dynamicTitleSummary.setId(View.generateViewId());
        dynamicTitleSummary.setText("QUEM VIU COMPROU");
        dynamicTitleSummary.setTextColor(
            ContextCompat.getColor(
                parentLayout.context,
                R.color.colorPrimaryDark
            )
        );
        dynamicTitleSummary.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f);
        parentLayout.addView(dynamicTitleSummary);
        Utils.ApplyInConstraintLayout(parentLayout, dynamicTitleSummary.id, idLastChildInfo)
        idLastChildInfo = dynamicTitleSummary.id;

        val params = ConstraintLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );

        //insere o layout de resumo do produto após todas as características do produto
        val layoutInflater = LayoutInflater.from(parentLayout.context);
        val child: View = layoutInflater.inflate(R.layout.summary_product, null);
        params.setMargins(0, 50, 0, 0);
        child.layoutParams = params;
        parentLayout.addView(child);
        Utils.ApplyInConstraintLayout(parentLayout, child.id, idLastChildInfo)

        summaryProducts?.let {
            it.forEach() {

                //Insere os resumos do produto (item quem viu comprou)
                var layoutNew: View = layoutInflater.inflate(R.layout.shared_item_summary, null);
                val imageView: ImageView = layoutNew.findViewById(R.id.item_image);
                val name: TextView = layoutNew.findViewById(R.id.item_name);
                val previousPrice: TextView = layoutNew.findViewById(R.id.item_previous_price);
                val currentPrice: TextView = layoutNew.findViewById(R.id.item_current_price);

                previousPrice.setPaintFlags(previousPrice.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG);

                Glide.with(parentLayout.context)
                    .asBitmap()
                    .override(imageView.width, imageView.height)
                    .load(it.ImageURI.replace("http", "https"))
                    .error(R.drawable.ic_menu_camera)
                    .into(imageView);

                name.setText(it.Name)
                previousPrice.setText(Utils.ConvertPrice(it.PreviousPrice));
                currentPrice.setText(Utils.ConvertPrice(it.CurrentPrice));
                (child.findViewById(R.id.linearLayoutHorizontal) as LinearLayout).addView(
                    layoutNew
                );
            }
        }
    }
}