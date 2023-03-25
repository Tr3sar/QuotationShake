package dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.newquotation

import dadm.jmartor.QuotationShake.ui.domain.model.Quotation

interface NewQuotationDataSource {
    suspend fun getQuotation():Result<Quotation>
}