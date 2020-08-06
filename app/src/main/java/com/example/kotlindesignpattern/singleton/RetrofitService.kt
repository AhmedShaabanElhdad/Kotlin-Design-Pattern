package com.example.kotlindesignpattern.singleton

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object RetrofitService {
    private const val BASE_URL = "https://test.com"

    private fun retrofitService(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    val profileApi: MyAPI by lazy {
        retrofitService().create(MyAPI::class.java)
    }

}

interface MyAPI {
    @GET("getName")
    fun getHomePageData(
        @Query("id") id: String) :Call<String>
}


