package dadm.jmartor.QuotationShake.ui.newquotation

import androidx.lifecycle.*
import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.favourites.FavouritesRepository
import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.newquotation.NewQuotationManager
import dadm.jmartor.QuotationShake.dadm.jmartor.QuotationShake.data.settings.SettingsRepository
import dadm.jmartor.QuotationShake.ui.domain.model.Quotation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewQuotationViewModel @Inject constructor(var manager: NewQuotationManager,
                                                  var settingsRepository: SettingsRepository,
                                                var favouritesRepository: FavouritesRepository): ViewModel() {

    private val _quotation: MutableLiveData<Quotation> = MutableLiveData<Quotation>()
    private val _iconoVisible: MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)
    private val _containsErrors: MutableLiveData<Throwable?> = MutableLiveData<Throwable?>()

    val userName: LiveData<String> = settingsRepository.getUsername().asLiveData()
    val quotation: LiveData<Quotation>
        get() {
            return _quotation
        }

    val iconoVisible: LiveData<Boolean>
        get() {
            return _iconoVisible
        }

    val welcomeMessage: LiveData<Boolean>
        get() {
            return Transformations.map(quotation) { it == null }
        }

    val botonVisible = quotation.switchMap() { newQuotation ->
        favouritesRepository.getQuotationById(newQuotation.id).asLiveData()
    }.map() { favourite ->
        favourite == null
    }

    val containsErrors: LiveData<Throwable?>
        get() {
            return _containsErrors
        }


    fun getNewQuotation() {
        _iconoVisible.value = true

        //val num = (0..99).random().toString()
        //_quotation.value = Quotation(num, "Quotation text #$num", "Author #$num")
        viewModelScope.launch {
            manager.getNewQuotation().fold(onSuccess = {
                _quotation.value = it
            }, onFailure = {
                _containsErrors.value = it
            })
        }

        _iconoVisible.value = false
    }

    fun addToFavorites() {
        viewModelScope.launch {
            try {
                favouritesRepository.insertQuotation(quotation.value!!)
                _iconoVisible.value = false
            } catch (e: Exception) {
                _containsErrors.value = e
            }
        }
    }

    private fun getUserName(): String {
        return setOf("Alice", "Bob", "Charlie", "David", "Emma").random()
    }

    fun resetError() {
        this._containsErrors.value = null
    }

}