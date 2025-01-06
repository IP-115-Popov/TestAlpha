package ru.sergey.data.repository

import ru.sergey.data.api.BinApi
import ru.sergey.data.models.BinInfo

class BinRepositoryImpl : BinRepository {
    override suspend fun get(id: Long): BinInfo {
        return BinApi.INSTANCE.get(id)
    }
}