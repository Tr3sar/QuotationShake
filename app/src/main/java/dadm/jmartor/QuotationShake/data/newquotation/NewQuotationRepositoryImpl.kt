package dadm.jmartor.dadm.jmartor.QuotationShake.data.newquotation

import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.newquotation.NewQuotationDataSource
import dadm.jmartor.QuotationShake.ui.domain.model.Quotation
import javax.inject.Inject

class NewQuotationRepositoryImpl @Inject() constructor(var dataSource: NewQuotationDataSource) : NewQuotationRepository{
    override suspend fun getNewQuotation(): Result<Quotation> {
        return dataSource.getQuotation()
    }
}