package dadm.jmartor.dadm.jmartor.QuotationShake.data.newquotation

import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.newquotation.ConnectivityChecker
import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.newquotation.NewQuotationDataSource
import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.utils.NoInternetException
import dadm.jmartor.QuotationShake.ui.domain.model.Quotation
import javax.inject.Inject

class NewQuotationRepositoryImpl @Inject() constructor(
    var dataSource: NewQuotationDataSource, var connectivityChecker: ConnectivityChecker) : NewQuotationRepository{
    override suspend fun getNewQuotation(): Result<Quotation> =
        if  (connectivityChecker.isConnectionAvailable()) {
            dataSource.getQuotation()
        }
        else Result.failure(NoInternetException())

}