package dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.settings

import dagger.Provides
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    fun getUsername() : Flow<String>
    fun getLanguage() : Flow<String>
}