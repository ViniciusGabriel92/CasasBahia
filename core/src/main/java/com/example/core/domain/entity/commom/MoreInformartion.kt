package com.example.core.domain.entity.commom

import com.google.gson.annotations.SerializedName

class MoreInformartion(
    @SerializedName("descricao")
    var Description: String,
    @SerializedName("valores")
    var InformationItems: List<InformationItem>
)

class InformationItem(
    @SerializedName("nome")
    var Name: String,
    @SerializedName("valor")
    var Value: String
)