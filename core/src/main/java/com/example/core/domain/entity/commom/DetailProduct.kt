package com.example.core.domain.entity.commom

import com.google.gson.annotations.SerializedName

data class DetailProduct(
    @SerializedName("id")
    var Id: Int,
    @SerializedName("nome")
    var Name: String,
    @SerializedName("descricao")
    var Description: String,
    @SerializedName("maisInformacoes")
    var MoreInformartions: List<MoreInformartion>,
    @SerializedName("modelo")
    var Model: Model
)

class Model(
    @SerializedName("padrao")
    var Pattern: Pattern
)

class Pattern(
    @SerializedName("preco")
    var Prrice: Price,
    @SerializedName("imagens")
var Images: List<Image>
)

class Image(
    @SerializedName("id")
    var Id: Int,
    @SerializedName("nome")
    var Name: String,
    @SerializedName("altura")
    var Height: String,
    @SerializedName("largura")
    var Width: String,
    @SerializedName("url")
    var URL: String
)