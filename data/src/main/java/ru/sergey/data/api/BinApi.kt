package ru.sergey.data.api

import retrofit2.http.GET
import retrofit2.http.Path
import ru.sergey.data.models.BinInfo

interface BinApi {
    @GET("{id}")
    suspend fun get(@Path("id") id: Long): BinInfo

    companion object {
        val INSTANCE: BinApi by lazy {
            RetrofitFactory.INSTANCE.create(BinApi::class.java)
        }
    }
}