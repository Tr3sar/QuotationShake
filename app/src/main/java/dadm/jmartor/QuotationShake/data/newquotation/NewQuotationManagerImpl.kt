package dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.newquotation

import android.util.Log
import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.settings.SettingsRepository
import dadm.jmartor.QuotationShake.ui.domain.model.Quotation
import dadm.jmartor.dadm.jmartor.QuotationShake.data.newquotation.NewQuotationRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewQuotationManagerImpl @Inject constructor(private val settingsRepository: SettingsRepository,
                                private val newQuotationRepository: NewQuotationRepository): NewQuotationManager {
    private lateinit var language: String
    init {
        CoroutineScope(SupervisorJob()).launch {
            settingsRepository.getLanguage().collect { languageCode ->
                language = languageCode
            }
        }
    }

    override suspend fun getNewQuotation(): Result<Quotation> {
        return newQuotationRepository.getNewQuotation(language)
    }

}