package ru.sergey.testalpha.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.sergey.data.repository.BinRepository
import ru.sergey.data.repository.BinRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
class DataModule {
    @Provides
    fun provideBinRepository(): BinRepository {
        return BinRepositoryImpl()
    }
}