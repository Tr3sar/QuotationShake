package dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.di

import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.favourites.FavouritesDataSource
import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.favourites.FavouritesDataSourceImpl
import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.favourites.FavouritesRepository
import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.favourites.FavouritesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FavouritesBinderModule {
    @Binds
    abstract fun bindFavouritesDataSource(favouritesDataSourceImpl: FavouritesDataSourceImpl): FavouritesDataSource

    @Binds
    abstract fun bindFavouritesRepository(favouritesRepositoryImpl: FavouritesRepositoryImpl): FavouritesRepository
}