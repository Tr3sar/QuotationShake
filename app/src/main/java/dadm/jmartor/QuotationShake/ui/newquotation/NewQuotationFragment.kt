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

        viewModel.iconoVisible.observe(viewLifecycleOwner) {iconoVisible ->
            binding.swipeToRefresh.isRefreshing = iconoVisible
        }

        viewModel.welcomeMessage.observe(viewLifecycleOwner) {welcomeMessage ->
            binding.mtBienvenida.visibility = if (welcomeMessage) View.VISIBLE else View.INVISIBLE
        }

        viewModel.quotation.observe(viewLifecycleOwner) { quotation ->
            if (quotation.autorCita.isNullOrBlank()) { binding.mtAutor.text = "Anonymous" }
            else { binding.mtAutor.text = quotation.autorCita}

            binding.mtCitaRecibida.text = quotation.nombreCita

        }

        binding.swipeToRefresh.setOnRefreshListener() {
            getNewQuotation()
        }
    }

    private fun getNewQuotation() {
        viewModel.getNewQuotation()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null;
    }
}