package dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.di

import android.content.Context
import androidx.room.Room
import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.favourites.FavouritesContract
import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.favourites.FavouritesDao
import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.favourites.FavouritesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FavouritesProviderModule {

    @Provides
    @Singleton
    fun provideFavouriteDataBase(@ApplicationContext context: Context): FavouritesDatabase {
        return Room.databaseBuilder(
            context,
            FavouritesDatabase::class.java,
            FavouritesContract.DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideFavouritesDao(favouritesDatabase: FavouritesDatabase) : FavouritesDao {
        return favouritesDatabase.favouritesDao()
    }
}