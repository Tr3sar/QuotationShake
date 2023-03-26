package dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.settings

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(private val settingsDataSource: SettingsDataSource): SettingsRepository  {
    override fun getUsername(): Flow<String> {
        return settingsDataSource.getUsername()
    }

}