package dadm.jmartor.QuotationShake.ui.newquotation

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import dadm.jmartor.QuotationShake.R
import dadm.jmartor.QuotationShake.databinding.FragmentNewQuotationBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NewQuotationFragment: Fragment(R.layout.fragment_new_quotation), MenuProvider {
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

        viewModel.botonVisible.observe(viewLifecycleOwner) { botonVisible ->
            binding.botonFav.visibility = if (botonVisible) View.VISIBLE else View.INVISIBLE
        }

        viewModel.quotation.observe(viewLifecycleOwner) { quotation ->
            if (quotation.autorCita.isNullOrBlank()) { binding.mtAutor.text = "Anonymous" }
            else { binding.mtAutor.text = quotation.autorCita}

            binding.mtCitaRecibida.text = quotation.nombreCita
        }

        binding.swipeToRefresh.setOnRefreshListener() {
            getNewQuotation()
        }

        binding.botonFav.setOnClickListener() {
            addTofavorites()
        }

        //Exercisi 12
        requireActivity().addMenuProvider(this,
            viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun getNewQuotation() {
        viewModel.getNewQuotation()
    }

    private fun addTofavorites() {
        viewModel.addToFavorites()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null;
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_new_quotation, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        if (menuItem.itemId == R.id.newQuotationFragment) {
            getNewQuotation()
            return true
        }
        return false
    }
}