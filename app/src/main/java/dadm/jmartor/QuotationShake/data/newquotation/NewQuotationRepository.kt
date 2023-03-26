package dadm.jmartor.dadm.jmartor.QuotationShake.data.newquotation

import dadm.jmartor.QuotationShake.ui.domain.model.Quotation

interface NewQuotationRepository {
    suspend fun getNewQuotation(language: String): Result<Quotation>
}