package dadm.jmartor.QuotationShake.ui.favourites

import android.opengl.GLES30
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dadm.jmartor.QuotationShake.R
import dadm.jmartor.QuotationShake.databinding.QuotationItemBinding
import dadm.jmartor.QuotationShake.ui.domain.model.Quotation

class QuotationListAdapter: ListAdapter<Quotation, QuotationListAdapter.ViewHolder>(
    QuotationDiffSingleton.QuotationDiff
) {
    class ViewHolder(private val binding: QuotationItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(quotation: Quotation) {
            binding.textoAutor.text = quotation.autorCita
            binding.textoCita.text = quotation.autorCita
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(QuotationItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class QuotationDiffSingleton {
    object QuotationDiff: DiffUtil.ItemCallback<Quotation>() {
        override fun areItemsTheSame(oldItem: Quotation, newItem: Quotation): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Quotation, newItem: Quotation): Boolean {
            return oldItem == newItem
        }
    }
}


