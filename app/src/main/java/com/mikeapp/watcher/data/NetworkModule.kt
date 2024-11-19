package com.mikeapp.watcher.data

import com.mikeapp.watcher.BuildConfig
import com.mikeapp.watcher.data.github.GithubApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(Interceptor { chain ->
            val originalRequest: Request = chain.request()
            val requestWithAuthorization: Request = originalRequest.newBuilder()
                .header(AUTHORIZATION_HEADER, BEARER_TOKEN)
                .build()
            chain.proceed(requestWithAuthorization)
        })
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY // Log request and response bodies
        })
        .build()

    private val retrofitGithub: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val githubApiService = retrofitGithub.create(GithubApiService::class.java)

    const val AUTHORIZATION_HEADER = "Authorization"
    const val BEARER_TOKEN = "Bearer ${BuildConfig.STATIC_API_TOKEN}"

    private val retrofitEspn: Retrofit = Retrofit.Builder()
        .baseUrl("https://www.espn.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}