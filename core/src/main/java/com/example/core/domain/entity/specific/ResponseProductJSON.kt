package com.example.core.domain.entity.specific

import com.example.core.domain.entity.commom.Product
import com.google.gson.annotations.SerializedName

class ResponseProductJSON(
    @SerializedName("produtos")
    var Produtos: List<Product>
)