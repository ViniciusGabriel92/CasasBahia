package com.example.infra.interfaces
import com.example.core.domain.entity.specific.ResponseProductJSON
import com.example.core.domain.entity.commom.DetailProduct
import com.example.core.domain.entity.commom.SummaryProduct
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

class API{

    interface EndpointProduct {
        @Headers("Accept: Application/JSON")
        @GET(".")
        fun getPosts() : Call<ResponseProductJSON>
    }

    interface EndpointDetail {
        @Headers("Accept: Application/JSON")
        @GET(".")
        fun getPosts(): Call<DetailProduct>
    }

    interface EndpointSummary {
        @Headers("Accept: Application/JSON")
        @GET(".")
        fun getPosts(): Call<List<SummaryProduct>>
    }
}