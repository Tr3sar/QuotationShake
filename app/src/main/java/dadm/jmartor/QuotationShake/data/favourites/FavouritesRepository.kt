package dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.favourites

import dadm.jmartor.QuotationShake.ui.domain.model.Quotation
import kotlinx.coroutines.flow.Flow

interface FavouritesRepository {
    suspend fun insertQuotation(quotation: Quotation)
    suspend fun deleteQuotation(quotation: Quotation)
    fun getAllQuotations(): Flow<List<Quotation>>
    fun getQuotationById(id: String): Flow<Quotation>
    suspend fun deleteAllQuotations()
}