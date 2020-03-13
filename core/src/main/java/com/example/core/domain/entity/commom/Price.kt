package com.example.core.domain.entity.commom

import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("precoAnterior")
    var PreviousPrice: Double,
    @SerializedName("precoAtual")
    var CurrentPrice: Double,
    @SerializedName("planoPagamento")
    var PaymentPlan: String,
    @SerializedName("valorParcela")
    var InstallmentPrice: Double,
    @SerializedName("quantidadeMaximaParcelas")
    var MaximumInstallment: Int,
    @SerializedName("porcentagemDesconto")
    var DiscountPercentage: Int
)