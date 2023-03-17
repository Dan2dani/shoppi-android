package com.shoppi.app.network

import com.shoppi.app.data.model.Category
import com.shoppi.app.data.model.CategoryDetail
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiClient {
    @GET("categories.json")
    suspend fun getCategories(): List<Category>

    @GET("fashion_female.json")
    suspend fun getCategoryDetails(): CategoryDetail

    companion object {
        private const val baseUrl =
            "https://shoppi-3db93-default-rtdb.asia-southeast1.firebasedatabase.app/"

        fun create(): ApiClient {
            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiClient::class.java)
        }
    }
}