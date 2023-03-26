package dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.favourites

import dadm.jmartor.QuotationShake.data.favourites.model.toDomain
import dadm.jmartor.QuotationShake.data.favourites.model.toDto
import dadm.jmartor.QuotationShake.ui.domain.model.Quotation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavouritesRepositoryImpl @Inject constructor(var favouritesDataSource: FavouritesDataSource) : FavouritesRepository {
    override suspend fun insertQuotation(quotation: Quotation) {
        favouritesDataSource.insertQuotation(quotation.toDto())
    }

    override suspend fun deleteQuotation(quotation: Quotation) {
        favouritesDataSource.deleteQuotation(quotation.toDto())
    }

    override fun getAllQuotations(): Flow<List<Quotation>> {
        return favouritesDataSource.getAllQuotations().map { list ->
            list.map { dto -> dto.toDomain() }
        }
    }

    override fun getQuotationById(id: String): Flow<Quotation?> {
        return favouritesDataSource.getQuotationById(id).map { dto ->
            dto?.toDomain()
        }
    }

    override suspend fun deleteAllQuotations() {
        favouritesDataSource.deleteAllQuotations()
    }
}