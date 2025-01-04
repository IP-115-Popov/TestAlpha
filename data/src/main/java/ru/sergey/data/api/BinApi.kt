package ru.sergey.data.api

import retrofit2.http.GET
import ru.sergey.data.models.BinInfo

interface BinApi {
    @GET("https://lookup.binlist.net/45717360")
    suspend fun get(): BinInfo
}