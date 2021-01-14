package cl.eme.contries.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.eme.contries.databinding.CountryItemListBinding
import cl.eme.contries.model.pojos.Country


class CountryAdapter : RecyclerView.Adapter<CountryAdapter.CountryVH>() {

    private var countriesList = listOf<Country>()

    private val selectedItem = MutableLiveData<Country>()

    fun selectedItem(): LiveData<Country> = selectedItem

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryVH {
        val binding = CountryItemListBinding.inflate(LayoutInflater.from(parent.context))

        return CountryVH(binding)
    }

    override fun onBindViewHolder(holder: CountryVH, position: Int) {
        val country = countriesList[position]
        holder.bind(country)
        holder.itemView.setOnClickListener {
            selectedItem.value = country
        }
    }

    override fun getItemCount(): Int {
        return countriesList.size
    }

    fun update(pCountriesList: List<Country>) {
        countriesList = pCountriesList
        notifyDataSetChanged()
    }

    inner class CountryVH(val binding: CountryItemListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(country : Country) {
            binding.tvName.text = country.name
        }
    }
}