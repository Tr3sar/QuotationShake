package dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.newquotation

import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.newquotation.model.QuotationDto
import dadm.jmartor.QuotationShake.ui.domain.model.Quotation
import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import javax.inject.Inject

class NewQuotationDataSourceImpl @Inject() constructor(var retrofit: Retrofit): NewQuotationDataSource {

    private val retrofitQuotationService = retrofit.create(NewQuotationRetrofit::class.java)
    interface NewQuotationRetrofit {
        @GET("api/1.0/?method=getQuote&format=json&lang=en")
        suspend fun getQuotation(): Response<QuotationDto>
    }
    override suspend fun getQuotation(): Response<QuotationDto> {
        return try {
            retrofitQuotationService.getQuotation()
        } catch (e: Exception) {
            Response.error(
                400, // Could be any other code and text, because we are not using it
                ResponseBody.create(MediaType.parse("text/plain"), e.toString())
            )
        }
    }
}