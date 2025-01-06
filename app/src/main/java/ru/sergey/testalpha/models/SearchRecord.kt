package ru.sergey.testalpha.models

import ru.sergey.data.storage.SearchRecordEntity

data class SearchRecord(
    val id: Long = 0L, val binNumber: Long
) {
    companion object {
        fun fromSearchRecordEntity(searchRecordEntity: SearchRecordEntity) =
            with(searchRecordEntity) {
                SearchRecord(
                    id = id, binNumber = binNumber
                )
            }
    }

    fun toSearchRecordEntity() = SearchRecordEntity(
        id = id, binNumber = binNumber
    )
}
