package com.example.infra.data

import com.example.core.domain.entity.commom.DetailProduct
import com.example.core.domain.entity.specific.ServiceProxy
import com.example.infra.NetworkUtils
import com.example.infra.interfaces.API
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type

//variáveis constantes
//TODO Vinicius: Implementar recuperação da URL através de DI
const val pathDetail = "https://www.mocky.io/v2/5d1b4fd23400004c000006e1/";

class RepositoryDetailProduct {

    fun getDetailProduct(serviceProxy: ServiceProxy){
        val retrofitClient =
            NetworkUtils.getRetrofitInstance(pathDetail);
        val endPoint = retrofitClient.create(API.EndpointDetail::class.java);
        val callback = endPoint.getPosts();
        callback.enqueue(object : Callback<DetailProduct> {
            override fun onFailure(call: Call<DetailProduct>, t: Throwable) {
                serviceProxy.onFailed(t);
            }

            override fun onResponse(call: Call<DetailProduct>, response: Response<DetailProduct>) {
                response.body()?.let {
                    if (response.code() == 200) {
                        var result: MutableList<DetailProduct> = ArrayList();
                        result.add(it);
                        serviceProxy.onData(result as List<Type>);
                    }
                }
            }
        });
    }
}