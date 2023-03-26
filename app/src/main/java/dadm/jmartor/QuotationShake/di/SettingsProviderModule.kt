package dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.di

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SettingsProviderModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context) : SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }
}