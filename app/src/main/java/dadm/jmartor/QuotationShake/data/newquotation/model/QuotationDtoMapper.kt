package dadm.jmartor.QuotationShake.data.newquotation.model
import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.newquotation.model.QuotationDto
import dadm.jmartor.QuotationShake.ui.domain.model.Quotation
import retrofit2.Response
import java.io.IOException

fun QuotationDto.toDomain() = Quotation(quoteLink,  quoteText, quoteAuthor)

fun Response<QuotationDto>.toDomain() =
    if (isSuccessful) Result.success((body() as QuotationDto).toDomain())
    else Result.failure(IOException())