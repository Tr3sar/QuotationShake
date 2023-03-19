package dadm.jmartor.QuotationShake.ui.favourites

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dadm.jmartor.QuotationShake.R
import dadm.jmartor.QuotationShake.databinding.FragmentFavouritesBinding

class NewFavouritesFragment: Fragment(R.layout.fragment_favourites) {
    private var _binding: FragmentFavouritesBinding? = null;
    private val binding get() = _binding!!;

    private val viewModel: FavouritesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentFavouritesBinding.bind(view);

        val adapter = QuotationListAdapter()
        binding.recyclerViewFavs.adapter = adapter

        viewModel.favList.observe(viewLifecycleOwner) {favList ->
            adapter.submitList(favList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null;
    }
}