package ru.sergey.data.repository

import ru.sergey.data.models.BinInfo

interface BinRepository {
    suspend fun get(id: Long): BinInfo
}