package com.example.tugasapi

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("/api/manga/page/1")
    fun getCEOs(): Call<CEOModel>
}