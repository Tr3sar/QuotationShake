package dadm.jmartor.QuotationShake.ui.favourites

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels

class DeleteAllDialogFragment : DialogFragment() {
    val viewModel: FavouritesViewModel by activityViewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle("Delete all favourite quotations")
            .setMessage("Do you really want to delete all quotations?")
            .setNegativeButton("No") { _,_ ->
                viewModel.dismiss()
            }
            .setPositiveButton("Yes") {_,_ ->
                viewModel.deleteAllQuotations()
            }.create()
    }
}