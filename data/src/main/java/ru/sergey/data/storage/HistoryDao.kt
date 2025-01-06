package ru.sergey.data.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
    @Query("SELECT * FROM ${SearchRecordEntity.TABLE_NAME}")
    fun getAll(): Flow<List<SearchRecordEntity>>

    @Insert
    fun save(searchRecordEntity: SearchRecordEntity)
}