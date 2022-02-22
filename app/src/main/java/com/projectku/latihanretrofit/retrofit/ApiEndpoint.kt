package com.projectku.latihanretrofit.retrofit

import com.projectku.latihanretrofit.MainModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {

    @GET("photos")
    fun getPhotos(): Call<List<MainModel>>

}