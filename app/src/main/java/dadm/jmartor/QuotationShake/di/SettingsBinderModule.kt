package dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.di

import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.settings.SettingsDataSource
import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.settings.SettingsDataSourceImpl
import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.settings.SettingsRepository
import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.settings.SettingsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SettingsBinderModule {
    @Binds
    abstract fun bindSettingsDataSource(settingsDataSourceImpl: SettingsDataSourceImpl) : SettingsDataSource

    @Binds
    abstract fun bindSettingsRepository(settingsDataSourceImpl: SettingsRepositoryImpl) : SettingsRepository
}