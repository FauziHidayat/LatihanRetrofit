package com.projectku.latihanretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.projectku.latihanretrofit.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart()
        getDataFromApi()
    }


    private fun getDataFromApi() {

        ApiService.endpoint.getPhotos()
            .enqueue(object : Callback<List<MainModel>> {
                override fun onResponse(
                    call: Call<List<MainModel>>,
                    response: Response<List<MainModel>>
                ) {
                    if (response.isSuccessful){
                        val result = response.body()
                        showPhotos(result!!)
                    }
                }

                override fun onFailure(call: Call<List<MainModel>>, t: Throwable) {
                    printMessage(t.toString())
                }

            })
    }


    private fun printMessage(message: String) {
        Log.d(TAG, message)
    }

    private fun showPhotos(photos: List<MainModel>){
        for(photo in photos){
            printMessage("url : ${photo.url}")
        }
    }

}