package ru.sergey.data.repository

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.sergey.data.models.BinInfo
import ru.sergey.data.storage.HistoryDao
import ru.sergey.data.storage.SearchRecordEntity

class HistoryRepositoryImpl(val historyDao: HistoryDao) : HistoryRepository {
    override suspend fun getAll(): Flow<List<SearchRecordEntity>> {
       return historyDao.getAll()
    }

    override suspend fun save(searchRecordEntity: SearchRecordEntity) {
        historyDao.save(searchRecordEntity)
    }
}