package dadm.jmartor.QuotationShake.ui.favourites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import dadm.jmartor.QuotationShake.ui.domain.model.Quotation

class FavouritesViewModel : ViewModel() {

    private val _favList = MutableLiveData<List<Quotation>>(getFavouriteQuotations())

    val isDeleteAllVisible = favList.map() {it.isNotEmpty()}

    val favList : LiveData<List<Quotation>>
        get() {
            return _favList
        }


    private fun getFavouriteQuotations() : List<Quotation>{
        val quotations = mutableListOf<Quotation>()
        for(i in 1..20) {
            val num = (1..99).random().toString()
            quotations.add(Quotation("Index $num", "Cita $num", "Autor $num"))
        }

        return quotations
    }

    fun deleteAllQuotations() {
        _favList.value = mutableListOf<Quotation>()
    }

    fun dismiss() {

    }

    fun deleteQuotationAtPost(position: Int) {
        val list = _favList.value?.toMutableList()
        list?.removeAt(position)
        _favList.value = list!!
    }
}