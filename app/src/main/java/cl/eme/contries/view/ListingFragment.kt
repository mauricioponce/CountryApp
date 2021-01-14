package cl.eme.contries.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cl.eme.contries.MyViewModel
import cl.eme.contries.R
import cl.eme.contries.databinding.FragmentListingBinding
import cl.eme.contries.model.pojos.Country
import timber.log.Timber

class ListingFragment : Fragment() {

    private lateinit var binding : FragmentListingBinding

    private val vm : MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListingBinding.inflate(layoutInflater)

        binding.rvCountriesList.layoutManager = LinearLayoutManager(context)

        val adapter = CountryAdapter()
        binding.rvCountriesList.adapter = adapter


        adapter.selectedItem().observe(viewLifecycleOwner, {
            Timber.d("hicimos click en $it")
            // A -> pasamos el ID al fragmento
            //activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_container, DetailFragment(it.alpha2Code))?.commit()

            // B -> pasamos el Country a viewModel
            vm.selected(it) //asignamos el seleccionado al viewmodel

            // abrimos el fragmento de detalle
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_container, DetailFragment())?.addToBackStack("detail")?.commit()
        })

        vm.countries().observe(viewLifecycleOwner, {
            adapter.update(it)
        })

        return binding.root
    }
}