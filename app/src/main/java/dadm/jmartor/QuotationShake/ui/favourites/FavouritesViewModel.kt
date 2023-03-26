package dadm.jmartor.QuotationShake.ui.favourites

import androidx.lifecycle.*
import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.favourites.FavouritesRepository
import dadm.jmartor.QuotationShake.ui.domain.model.Quotation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject() constructor(var favouritesRepository: FavouritesRepository): ViewModel() {


    val isDeleteAllVisible = favList.map() {it.isNotEmpty()}

    val favList : LiveData<List<Quotation>>
        get() {
            return favouritesRepository.getAllQuotations().asLiveData()
        }

    fun deleteAllQuotations() {
        viewModelScope.launch {
            favouritesRepository.deleteAllQuotations()
        }
    }

    fun dismiss() {

    }

    fun deleteQuotationAtPost(position: Int) {
        viewModelScope.launch {
            favList.value?.toMutableList()?.get(position)?.let { favouritesRepository.deleteQuotation(it) }
        }
    }
}