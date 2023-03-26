package dadm.jmartor.QuotationShake.ui.favourites

import androidx.lifecycle.*
import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.favourites.FavouritesRepository
import dadm.jmartor.QuotationShake.ui.domain.model.Quotation
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject() constructor(var favouritesRepository: FavouritesRepository): ViewModel() {


    val isDeleteAllVisible = favList.map() {it.isNotEmpty()}

    val favList : LiveData<List<Quotation>>
        get() {
            return favouritesRepository.getAllQuotations().asLiveData()
        }

    fun deleteAllQuotations() {
        //_favList.value = mutableListOf<Quotation>()
    }

    fun dismiss() {

    }

    fun deleteQuotationAtPost(position: Int) {
        //val list = _favList.value?.toMutableList()
        //list?.removeAt(position)
        //_favList.value = list!!
    }
}