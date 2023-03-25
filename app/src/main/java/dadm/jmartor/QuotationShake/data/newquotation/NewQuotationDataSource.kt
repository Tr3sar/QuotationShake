package dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.newquotation

import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.newquotation.model.QuotationDto
import retrofit2.Response

interface NewQuotationDataSource {
    suspend fun getQuotation():Response<QuotationDto>
}