package ru.sergey.data.repository

import kotlinx.coroutines.flow.Flow
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