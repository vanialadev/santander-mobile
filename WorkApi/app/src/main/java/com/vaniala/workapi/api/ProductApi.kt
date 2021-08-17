package com.vaniala.workapi.api

import com.vaniala.workapi.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductApi {

    @GET("getdata.php")
    fun getProductsApi(): Call<List<Product>>
}