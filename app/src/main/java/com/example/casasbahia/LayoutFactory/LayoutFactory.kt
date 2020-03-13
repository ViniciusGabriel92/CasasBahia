package com.example.casasbahia.LayoutFactory

import androidx.constraintlayout.widget.ConstraintLayout
import java.lang.reflect.Type

class LayoutFactory(var layoutFactory: ILayoutFactory) {

    fun InsertComponent(parentLayout: ConstraintLayout, objectsComponent: List<Type>){

        layoutFactory.InsertComponent(parentLayout, objectsComponent);
    }
}