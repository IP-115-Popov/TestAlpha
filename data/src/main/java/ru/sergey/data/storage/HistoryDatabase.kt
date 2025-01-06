package ru.sergey.data.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [SearchRecordEntity::class], version = 1
)
abstract class HistoryDatabase: RoomDatabase() {
    abstract fun historyDao(): HistoryDao

    companion object {
        const val DATABASE_NAME = "history_database.db"

        @Volatile
        private var INSTANCE: HistoryDatabase? = null

        fun getInstance(context: Context): HistoryDatabase {
            INSTANCE?.let { return it }
            val application = context.applicationContext
            synchronized(this) {
                INSTANCE?.let { return it }
                val appDb =
                    Room.databaseBuilder(application, HistoryDatabase::class.java, DATABASE_NAME)
                        .fallbackToDestructiveMigration().build()
                INSTANCE = appDb
                return appDb
            }
        }
    }
}