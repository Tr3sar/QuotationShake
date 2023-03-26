package dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.settings

import kotlinx.coroutines.flow.Flow


interface SettingsDataSource {
    fun getUsername() : Flow<String>
    fun getLanguage() : Flow<String>
}