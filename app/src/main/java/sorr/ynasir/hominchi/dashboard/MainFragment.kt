package sorr.ynasir.hominchi.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import sorr.ynasir.hominchi.R
import sorr.ynasir.hominchi.dashboard.adapter.CarouselAdapter
import sorr.ynasir.hominchi.databinding.FragmentMainBinding
import sorr.ynasir.hominchi.utilities.Utilities.Companion.dataImg
import sorr.ynasir.hominchi.utilities.Utilities.Companion.setTimer

class MainFragment : Fragment(), View.OnClickListener {

    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater,container,false)
        val rootView = binding.root
        setupOnClick()
        setupCarousel()

        return rootView
    }

    private fun setupCarousel() {
        binding.carouselView.apply {
            adapter = CarouselAdapter(dataImg)
            setTimer(this, dataImg.size)
        }
        binding.carouselIndicator.setViewPager2(binding.carouselView)
    }
    private fun setupOnClick() {
        binding.homeCard.setOnClickListener(this)
        binding.guideCard.setOnClickListener(this)
        binding.tipsCard.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v){
            binding.homeCard -> findNavController().navigate(R.id.action_mainFragment_to_homeFragment)
            binding.guideCard -> findNavController().navigate(R.id.action_mainFragment_to_guideFragment)
            binding.tipsCard -> findNavController().navigate(R.id.action_mainFragment_to_tipsFragment)
        }
    }
}