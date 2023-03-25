package dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.newquotation

import dadm.jmartor.QuotationShake.ui.domain.model.Quotation
import javax.inject.Inject

class NewQuotationDataSourceImpl @Inject() constructor(): NewQuotationDataSource {
    override suspend fun getQuotation(): Result<Quotation> {
        return if ((0..99).random() < 90) {
            val num = (0..99).random().toString()
            val quotation = Quotation(num, "Quotation text #$num", "Author #$num")
            Result.success(quotation)
        } else {
            Result.failure(Exception())
        }
    }
}