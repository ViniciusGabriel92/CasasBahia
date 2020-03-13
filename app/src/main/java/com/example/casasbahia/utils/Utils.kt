package com.example.casasbahia.utils

import android.R
import android.app.AlertDialog
import android.content.Context
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import java.text.DecimalFormat


class Utils {

    companion object {

        fun ApplyInConstraintLayout(parentLayout: ConstraintLayout, idChild: Int, idParent: Int) {
            val constraintSet = ConstraintSet();
            constraintSet.clone(parentLayout);
            constraintSet.connect(
                idChild,
                ConstraintSet.TOP,
                idParent,
                ConstraintSet.BOTTOM
            );
            constraintSet.applyTo(parentLayout);
        }

        fun ConvertPrice(price: Double): String {
            return DecimalFormat("R$ ##,##0.00").format(price);
        }

        fun CreateAlertDialog(
            context: Context,
            title: String,
            message: String
        ): AlertDialog.Builder {
            val builder = AlertDialog.Builder(context);
            builder.setTitle(title);
            builder.setMessage(message);
            return builder;
        }

        fun GetProgressBar(parentLayout: ConstraintLayout): ProgressBar? {
            return parentLayout.findViewById<ProgressBar>(com.example.casasbahia.R.id.sharedProgressBar);
        }
    }
}
