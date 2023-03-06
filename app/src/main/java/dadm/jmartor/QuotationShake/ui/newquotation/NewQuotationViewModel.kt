package dadm.jmartor.QuotationShake.ui.newquotation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewQuotationViewModel: ViewModel() {
    private val mutableUsername: MutableLiveData<String> = MutableLiveData<String>(getUserName())
    val userName: LiveData<String>
        get() {
            return mutableUsername
        }

    private fun getUserName(): String {
        return setOf("Alice", "Bob", "Charlie", "David", "Emma").random()
    }
}