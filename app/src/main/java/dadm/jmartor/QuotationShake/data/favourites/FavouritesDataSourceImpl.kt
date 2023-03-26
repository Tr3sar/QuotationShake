package dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.favourites

import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.favourites.model.QuotationDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavouritesDataSourceImpl @Inject constructor(var favouritesDao: FavouritesDao) : FavouritesDataSource {
    override suspend fun insertQuotation(quotation: QuotationDto) {
        favouritesDao.insertQuotation(quotation)
    }

    override suspend fun deleteQuotation(quotation: QuotationDto) {
        favouritesDao.deleteQuotation(quotation)
    }

    override fun getAllQuotations(): Flow<List<QuotationDto>> {
        return favouritesDao.getAllQuotations()
    }

    override fun getQuotationById(id: String): Flow<QuotationDto> {
        return favouritesDao.getQuotationById(id)
    }

    override suspend fun deleteAllQuotations() {
        favouritesDao.deleteAllQuotations()
    }
}