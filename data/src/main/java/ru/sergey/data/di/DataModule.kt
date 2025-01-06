package ru.sergey.data.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import ru.sergey.data.repository.BinRepository
import ru.sergey.data.repository.BinRepositoryImpl
import ru.sergey.data.repository.HistoryRepository
import ru.sergey.data.repository.HistoryRepositoryImpl
import ru.sergey.data.storage.HistoryDao
import ru.sergey.data.storage.HistoryDatabase

@Module
@InstallIn(ViewModelComponent::class)
class DataModule {

    @Provides
    fun provideBinRepository(): BinRepository {
        return BinRepositoryImpl()
    }

    @Provides
    fun provideHistoryRepository(historyDao: HistoryDao): HistoryRepository {
        return HistoryRepositoryImpl(historyDao)
    }

    @Provides
    fun provideHistoryDao(@ApplicationContext context: Context): HistoryDao {
        return HistoryDatabase.getInstance(context = context).historyDao()
    }
}