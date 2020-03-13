package com.example.infra.data

import com.example.core.domain.entity.commom.SummaryProduct
import com.example.core.domain.entity.specific.ServiceProxy
import com.example.infra.NetworkUtils
import com.example.infra.interfaces.API
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type

//variáveis constantes
//TODO Vinicius: Implementar recuperação da URL através de DI
const val pathSummary = "https://www.mocky.io/v2/5d1b507634000054000006ed/";

class RepositorySummaryProduct {

    fun getSummaryProduct(serviceProxy: ServiceProxy) {
        val retrofitClient =
            NetworkUtils.getRetrofitInstance(pathSummary);
        val endPoint = retrofitClient.create(API.EndpointSummary::class.java);
        val callback = endPoint.getPosts();

        callback.enqueue(object : Callback<List<SummaryProduct>> {
            override fun onFailure(call: Call<List<SummaryProduct>>, t: Throwable) {
                serviceProxy.onFailed(t);
            }

            override fun onResponse(
                call: Call<List<SummaryProduct>>,
                response: Response<List<SummaryProduct>>
            ) {
                response.body()?.let {
                    if (response.code() == 200) {
                        serviceProxy.onData(it as List<Type>);
                    }
                }
            }
        });
    }

}