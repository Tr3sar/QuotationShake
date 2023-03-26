package dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.favourites

import androidx.room.*
import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.favourites.FavouritesContract.entries.COLUMN_ID
import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.favourites.FavouritesContract.entries.TABLE_NAME
import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.favourites.model.QuotationDto
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouritesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuotation(quotation : QuotationDto)

    @Delete
    suspend fun deleteQuotation(quotation: QuotationDto)

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllQuotations() : Flow<List<QuotationDto>>

    @Query("SELECT * FROM $TABLE_NAME WHERE $COLUMN_ID = :id")
    fun getQuotationById(id: String): Flow<QuotationDto?>

    @Query("DELETE FROM $TABLE_NAME")
    suspend fun deleteAllQuotations()
}