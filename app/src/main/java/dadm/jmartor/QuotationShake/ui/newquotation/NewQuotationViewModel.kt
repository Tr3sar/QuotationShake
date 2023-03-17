package dadm.jmartor.QuotationShake.ui.newquotation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import dadm.jmartor.QuotationShake.ui.domain.model.Quotation

class NewQuotationViewModel: ViewModel() {
    private val _username: MutableLiveData<String> = MutableLiveData<String>(getUserName())
    private val _quotation: MutableLiveData<Quotation> = MutableLiveData<Quotation>()
    private val _iconoVisible: MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)


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


    fun getNewQuotation() {
        _iconoVisible.value = true

        val num = (0..99).random().toString()
        _quotation.value = Quotation(num, "Quotation text #$num", "Author #$num")


        _iconoVisible.value = false
    }

    private fun getUserName(): String {
        return setOf("Alice", "Bob", "Charlie", "David", "Emma").random()
    }

}