package dadm.jmartor.QuotationShake.ui.newquotation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dadm.jmartor.QuotationShake.R
import dadm.jmartor.QuotationShake.databinding.FragmentNewQuotationBinding

class NewQuotationFragment: Fragment(R.layout.fragment_new_quotation) {
    private var _binding: FragmentNewQuotationBinding? = null;
    private val binding get() = _binding!!;
    private val viewModel: NewQuotationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentNewQuotationBinding.bind(view);

        viewModel.userName.observe(viewLifecycleOwner) { userName ->
            binding.mtBienvenida.text = getString(R.string.welcomeMessage, userName)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null;
    }
}