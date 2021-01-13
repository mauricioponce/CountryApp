package cl.eme.contries.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cl.eme.contries.MyViewModel
import cl.eme.contries.databinding.FragmentListingBinding

class ListingFragment : Fragment() {

    private lateinit var binding : FragmentListingBinding

    private val vm : MyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListingBinding.inflate(layoutInflater)

        binding.rvCountriesList.layoutManager = LinearLayoutManager(context)


        val adapter = CountryAdapter()
        binding.rvCountriesList.adapter = adapter


        vm.countries().observe(viewLifecycleOwner, {
            adapter.update(it)
        })

        return binding.root
    }
}