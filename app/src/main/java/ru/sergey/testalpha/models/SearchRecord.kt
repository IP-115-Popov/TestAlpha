package ru.sergey.testalpha.models

import ru.sergey.data.storage.SearchRecordEntity

data class SearchRecord(
    val binNumber: Long
) {
    companion object {
        fun fromSearchRecordEntity(searchRecordEntity: SearchRecordEntity) =
            with(searchRecordEntity) {
                SearchRecord(
                    binNumber = binNumber
                )
            }
    }

    fun toSearchRecordEntity() = SearchRecordEntity(
        binNumber = binNumber
    )
}
