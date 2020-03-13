package com.example.casasbahia.LayoutFactory

import androidx.constraintlayout.widget.ConstraintLayout
import java.lang.reflect.Type

interface ILayoutFactory {

    fun InsertComponent(parentLayout: ConstraintLayout, objectsComponent: List<Type>);
}