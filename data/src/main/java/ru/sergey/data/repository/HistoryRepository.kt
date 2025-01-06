package ru.sergey.data.repository

import kotlinx.coroutines.flow.Flow
import ru.sergey.data.models.BinInfo
import ru.sergey.data.storage.SearchRecordEntity

interface HistoryRepository {
    suspend fun getAll(): Flow<List<SearchRecordEntity>>

    suspend fun save(searchRecordEntity: SearchRecordEntity)
}