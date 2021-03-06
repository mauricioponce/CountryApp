package cl.eme.contries.view

import android.content.Intent
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

        vm.getDetail().observe(viewLifecycleOwner, { detail ->
            binding.tvName.text = detail.name
            binding.tvRegion.text = detail.region
            binding.tvSubRegion.text = detail.subregion

            binding.floatingShare.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, detail.toString())

                startActivity(intent)
            }
        })

        return binding.root
    }
}