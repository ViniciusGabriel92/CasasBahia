package com.example.casasbahia.LayoutFactory

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.example.casasbahia.R
import com.example.casasbahia.utils.Utils
import com.example.core.domain.entity.commom.MoreInformartion
import java.lang.reflect.Type

class FactoryMoreInformation : ILayoutFactory {

    override fun InsertComponent(parentLayout: ConstraintLayout, objectsComponent: List<Type>) {
        insertMoreInformation(parentLayout, objectsComponent as List<MoreInformartion>);
    }

    fun insertMoreInformation(
        parentLayout: ConstraintLayout,
        moreInformartions: List<MoreInformartion>
    ) {
        val constraintSet = ConstraintSet();
        var idLastDescriptionInfo = (parentLayout.findViewById(R.id.dp_btn_buy) as Button).id;
        moreInformartions.forEach()
        {
            //#region Title
            val tvDescription = buildTitleMoreInformation(parentLayout.context, it.Description);
            parentLayout.addView(tvDescription);
            Utils.ApplyInConstraintLayout(parentLayout, tvDescription.id, idLastDescriptionInfo);
            //#endregion

            var idLastItemInformation = tvDescription.id;
            it.InformationItems.forEach() {
                //#region Name
                val tvName = buildNameMoreInformation(parentLayout.context, it.Name);
                parentLayout.addView(tvName);
                Utils.ApplyInConstraintLayout(parentLayout, tvName.id, idLastItemInformation);
                //#endregion

                //#region Value
                var tvValue = buildValueMoreInformation(parentLayout.context, it.Value);
                parentLayout.addView(tvValue);
                Utils.ApplyInConstraintLayout(parentLayout, tvValue.id, tvName.id);
                idLastItemInformation = tvValue.id;
                idLastDescriptionInfo = tvValue.id;
                //#endregion
            }
        }

    }

    fun buildTitleMoreInformation(context: Context, value: String): TextView {
        //Element title
        val dynamicTextViewTitle = TextView(context);
        val params = ConstraintLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 40, 0, 0);
        dynamicTextViewTitle.layoutParams = params;
        dynamicTextViewTitle.setId(View.generateViewId());
        dynamicTextViewTitle.setText(value);
        dynamicTextViewTitle.setTextColor(
            ContextCompat.getColor(
                context,
                R.color.colorPrimaryDark
            )
        );
        dynamicTextViewTitle.setTypeface(Typeface.DEFAULT_BOLD);
        dynamicTextViewTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f);
        return dynamicTextViewTitle;
    }

    fun buildNameMoreInformation(context: Context, value: String): TextView {
        //Element name
        val dynamicTextViewName = TextView(context);
        val params = ConstraintLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 20, 0, 0);
        dynamicTextViewName.layoutParams = params;
        dynamicTextViewName.setId(View.generateViewId());
        dynamicTextViewName.setText(value);
        dynamicTextViewName.setTextColor(Color.BLACK);
        dynamicTextViewName.setTypeface(Typeface.DEFAULT_BOLD);
        dynamicTextViewName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15f);
        return dynamicTextViewName;
    }

    fun buildValueMoreInformation(context: Context, value: String): TextView {
        //Element value
        val dynamicTextViewValue = TextView(context);
        val params = ConstraintLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        dynamicTextViewValue.layoutParams = params;
        dynamicTextViewValue.setId(View.generateViewId());
        dynamicTextViewValue.setText(value);
        dynamicTextViewValue.setTextColor(Color.BLACK);
        dynamicTextViewValue.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15f);
        return dynamicTextViewValue;
    }
}