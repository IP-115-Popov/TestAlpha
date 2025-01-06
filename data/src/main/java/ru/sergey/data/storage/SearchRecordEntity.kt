package ru.sergey.data.storage

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.sergey.data.storage.SearchRecordEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class SearchRecordEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = BIN_NUMBER)
    val binNumber: Long
) {
    companion object {
        const val TABLE_NAME = "history"
        const val BIN_NUMBER = "binNumber"
    }
}