package dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.favourites

import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.favourites.model.QuotationDto
import kotlinx.coroutines.flow.Flow

interface FavouritesDataSource {
    suspend fun insertQuotation(quotation: QuotationDto)
    suspend fun deleteQuotation(quotation: QuotationDto)
    fun getAllQuotations(): Flow<List<QuotationDto>>
    fun getQuotationById(id: String): Flow<QuotationDto?>
    suspend fun deleteAllQuotations()
}