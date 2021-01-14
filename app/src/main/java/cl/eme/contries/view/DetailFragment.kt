package cl.eme.contries.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import cl.eme.contries.MyViewModel
import cl.eme.contries.databinding.FragmentDetailBinding
import timber.log.Timber

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    private val vm : MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater)

        vm.selected().observe(viewLifecycleOwner,{
            Timber.d("el pais en el detalle es $it")
        } )

        return binding.root
    }
}