package dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.favourites.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.favourites.FavouritesContract.entries.COLUMN_AUTHOR
import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.favourites.FavouritesContract.entries.COLUMN_ID
import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.favourites.FavouritesContract.entries.COLUMN_TEXT
import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.favourites.FavouritesContract.entries.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class QuotationDto(
    @PrimaryKey
    @ColumnInfo(name = COLUMN_ID)
    val id: String,
    @ColumnInfo(name = COLUMN_TEXT)
    val text: String,
    @ColumnInfo(name = COLUMN_AUTHOR) val author: String
)
