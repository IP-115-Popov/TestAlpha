package ru.sergey.data.api

import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

class RetrofitFactory {
    private val json = Json {
        ignoreUnknownKeys = true
    }

    val INSTANCE by lazy {
        Retrofit.Builder()
            .baseUrl("https://eltex-android.ru/")
            .addConverterFactory(json.asConverterFactory())
            .build()
    }
}