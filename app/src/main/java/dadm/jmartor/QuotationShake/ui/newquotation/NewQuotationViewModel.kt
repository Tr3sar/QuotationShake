package dadm.jmartor.QuotationShake.ui.newquotation

import androidx.lifecycle.*
import dadm.jmartor.QuotationShake.ui.domain.model.Quotation
import dadm.jmartor.dadm.jmartor.QuotationShake.data.newquotation.NewQuotationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewQuotationViewModel @Inject() constructor(var repository: NewQuotationRepository): ViewModel() {
    private val _username: MutableLiveData<String> = MutableLiveData<String>(getUserName())
    private val _quotation: MutableLiveData<Quotation> = MutableLiveData<Quotation>()
    private val _iconoVisible: MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)
    private val _botonVisible: MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)
    private val _containsErrors: MutableLiveData<Throwable?> = MutableLiveData<Throwable?>()


    val userName: LiveData<String>
        get() {
            return _username
        }

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

    val botonVisible: LiveData<Boolean>
        get() {
            return _botonVisible
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
            repository.getNewQuotation().fold(onSuccess = {
                _quotation.value = it
            }, onFailure = {
                _containsErrors.value = it
            })
        }

        _iconoVisible.value = false
        _botonVisible.value = true
    }

    fun addToFavorites() {
        _botonVisible.value = false
    }

    private fun getUserName(): String {
        return setOf("Alice", "Bob", "Charlie", "David", "Emma").random()
    }

    fun resetError() {
        this._containsErrors.value = null
    }

}