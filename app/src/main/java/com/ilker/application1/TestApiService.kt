package com.ilker.application1

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

interface TestApiService {

    @GET("{url}")
    fun getProps(@Path("url") url: String): Call<String>
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object TestApi {

    val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val retrofitService : TestApiService by lazy {
        retrofit.create(TestApiService::class.java)
    }

}