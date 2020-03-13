package com.example.infra.data

import com.example.core.domain.entity.specific.ResponseProductJSON
import com.example.core.domain.entity.specific.ServiceProxy
import com.example.infra.interfaces.API
import com.example.infra.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type

//variáveis constantes
//TODO Vinicius: Implementar recuperação da URL através de DI
const val path = "https://www.mocky.io/v2/5d1b4f0f34000074000006dd/";

 class RepositoryProduct {

      fun getProducts(serviceProxy: ServiceProxy) {

        val retrofitClient = NetworkUtils.getRetrofitInstance(path);
        val endPoint = retrofitClient.create(API.EndpointProduct::class.java);
        val callback = endPoint.getPosts();

        callback.enqueue(object : Callback<ResponseProductJSON> {
            override fun onFailure(call: Call<ResponseProductJSON>, t: Throwable) {
                serviceProxy.onFailed(t);
            }

            override fun onResponse(
                call: Call<ResponseProductJSON>,
                response: Response<ResponseProductJSON>
            ) {
                response.body()?.let {
                    if (response.code() == 200) {
                        it as ResponseProductJSON
                        serviceProxy.onData(it.Produtos as List<Type>);
                    }
                }
            }
        });
    }
}