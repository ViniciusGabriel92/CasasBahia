package com.example.casasbahia.builders

import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.casasbahia.LayoutFactory.FactorySummaryProduct
import com.example.casasbahia.LayoutFactory.LayoutFactory
import com.example.core.domain.entity.commom.SummaryProduct
import com.example.core.domain.entity.specific.ServiceProxy
import java.lang.reflect.Type

class BuilderSummary(parentLayout: ConstraintLayout) : ServiceProxy {

    lateinit var parentLayout: ConstraintLayout;

    init {
        this.parentLayout = parentLayout;
    }

    override fun onData(data: List<Type>) {
        val factory = LayoutFactory(FactorySummaryProduct());
        factory.InsertComponent(parentLayout, data);
        Log.e(TAG, "Total de resumo retornado: " + (data as List<SummaryProduct>).size);
    }

    override fun onFailed(t: Throwable) {
        Log.e(TAG, "Erro: " + t.localizedMessage);
    }

    companion object {
        private val TAG = SummaryProduct::class.java.simpleName
    }
}