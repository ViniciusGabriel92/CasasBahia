package com.example.core.domain.entity.commom

import com.google.gson.annotations.SerializedName

data class SummaryProduct (
    @SerializedName("id")
    var Id: Int,
    @SerializedName("nome")
    var Name: String,
    @SerializedName("imagemUrl")
    var ImageURI: String,
    @SerializedName("precoAnterior")
    var PreviousPrice: Double,
    @SerializedName("precoAtual")
    var CurrentPrice: Double
)