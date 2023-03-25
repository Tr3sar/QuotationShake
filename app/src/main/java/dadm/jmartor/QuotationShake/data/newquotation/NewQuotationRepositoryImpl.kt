package dadm.jmartor.dadm.jmartor.QuotationShake.data.newquotation

import dadm.jmartor.QuotationShake.ui.domain.model.Quotation
import javax.inject.Inject

class NewQuotationRepositoryImpl @Inject() constructor() : NewQuotationRepository{
    override suspend fun getNewQuotation(): Result<Quotation> {
        return if ((0..99).random() < 90) {
            val num = (0..99).random().toString()
            val quotation = Quotation(num, "Quotation text #$num", "Author #$num")
            Result.success(quotation)
        } else {
            Result.failure(Exception())
        }
    }
}