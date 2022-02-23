package com.projectku.latihanretrofit.retrofit

import com.projectku.latihanretrofit.MainModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {

    @GET("data.php")
    fun getData(): Call<MainModel>

}