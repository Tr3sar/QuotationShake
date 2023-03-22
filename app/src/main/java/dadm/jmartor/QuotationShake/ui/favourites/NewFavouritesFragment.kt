package dadm.jmartor.QuotationShake.ui.favourites

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.END
import androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback
import androidx.recyclerview.widget.RecyclerView
import dadm.jmartor.QuotationShake.R
import dadm.jmartor.QuotationShake.databinding.FragmentFavouritesBinding

class NewFavouritesFragment: Fragment(R.layout.fragment_favourites), MenuProvider {
    private var _binding: FragmentFavouritesBinding? = null;
    private val binding get() = _binding!!;
    private val viewModel: FavouritesViewModel by activityViewModels()

    val touchHelper = ItemTouchHelper(object: SimpleCallback(0, END) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun isLongPressDragEnabled(): Boolean {
            return false
        }

        override fun isItemViewSwipeEnabled(): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            viewModel.deleteQuotationAtPost(viewHolder.adapterPosition)
        }
    })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentFavouritesBinding.bind(view);

        val adapter = QuotationListAdapter()
        binding.recyclerViewFavs.adapter = adapter

        viewModel.favList.observe(viewLifecycleOwner) {favList ->
            adapter.submitList(favList)
        }

        viewModel.isDeleteAllVisible.observe(viewLifecycleOwner) {isVisible ->
            requireActivity().invalidateMenu()
        }

        touchHelper.attachToRecyclerView(binding.recyclerViewFavs)


        requireActivity().addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    override fun onPrepareMenu(menu: Menu) {
        super.onPrepareMenu(menu)
        menu.findItem(R.id.deleteAllDialogFragment).isVisible = viewModel.isDeleteAllVisible.value == true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null;
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_favourites, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        if (menuItem.itemId == R.id.deleteAllDialogFragment) {
            findNavController().navigate(R.id.deleteAllDialogFragment)
            return true
        }

        return false
    }
}