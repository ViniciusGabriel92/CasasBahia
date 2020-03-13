package com.example.core.domain.entity.commom

import com.example.core.domain.entity.commom.Price
import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id")
    var Id: Int,
    @SerializedName("nome")
    var Name: String,
    @SerializedName("descricao")
    var Description: String,
    @SerializedName("imagemUrl")
    var ImageURI: String,
    @SerializedName("preco")
    var Price: Price
)
