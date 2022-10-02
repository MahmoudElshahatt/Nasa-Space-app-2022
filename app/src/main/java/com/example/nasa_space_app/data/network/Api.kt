package com.example.nasa_space_app.data.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Api {
    @GET("chart")
    fun getEverything() : Call<Int>
}

val retrofit = Retrofit.Builder()
    .baseUrl("https://newsapi.org/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val service = retrofit.create(Api::class.java)