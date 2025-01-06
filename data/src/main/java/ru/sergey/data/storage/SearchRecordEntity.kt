package ru.sergey.data.storage

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.sergey.data.storage.SearchRecordEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class SearchRecordEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = SEARCH_RECORD_ID)
    val id: Long,

    @NonNull
    @ColumnInfo(name = BIN_NUMBER)
    val binNumber: Long
) {
    companion object {
        const val TABLE_NAME = "history"
        const val SEARCH_RECORD_ID = "search_record_id"
        const val BIN_NUMBER = "binNumber"
    }
}