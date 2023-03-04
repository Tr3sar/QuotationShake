package dadm.jmartor.QuotationShake.ui.favourites

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dadm.jmartor.QuotationShake.R
import dadm.jmartor.QuotationShake.databinding.FragmentFavouritesBinding

class NewFavouritesFragment: Fragment(R.layout.fragment_favourites) {
    private var _binding: FragmentFavouritesBinding? = null;
    private val binding get() = _binding!!;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentFavouritesBinding.bind(view);
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null;
    }
}