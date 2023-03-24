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
import kotlinx.coroutines.flow.callbackFlow

class QuotationListAdapter(private val itemClicked: ItemClicked): ListAdapter<Quotation, QuotationListAdapter.ViewHolder>(
    QuotationDiffSingleton.QuotationDiff) {
    class ViewHolder(private val binding: QuotationItemBinding, itemClicked: ItemClicked) : RecyclerView.ViewHolder(binding.root) {

        init{
            binding.root.setOnClickListener {
                itemClicked.onClick(binding.textoAutor.text.toString())
            }
        }
        fun bind(quotation: Quotation) {
            binding.textoAutor.text = quotation.autorCita
            binding.textoCita.text = quotation.autorCita
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(QuotationItemBinding.inflate(LayoutInflater.from(parent.context)), itemClicked)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

interface ItemClicked {
    fun onClick(author: String)
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


