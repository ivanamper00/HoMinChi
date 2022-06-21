package sorr.ynasir.hominchi.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.AppBarLayout
import sorr.ynasir.hominchi.R
import sorr.ynasir.hominchi.databinding.FragmentHomeBinding
import sorr.ynasir.hominchi.home.adapter.HomeAdapter


class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var homeData = HomeViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        val rootView = binding.root
        homeData = ViewModelProvider(this)[HomeViewModel::class.java]


        with(binding){
            appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
                val predicate: Float = ((verticalOffset * -1F) / appBarLayout.totalScrollRange)
                println("predicate $predicate")
                toolbarTitle.alpha = predicate
            })

            bckButton.setOnClickListener {
                onBackClick()
            }
        }

        homeData.homeFun()
        val adpts = HomeAdapter()
        homeData.hmdtls.observe(viewLifecycleOwner){
            if (it != null){
                adpts.setAdapter(it)
                binding.homeRecycler.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(context)
                    adapter = adpts
                }
            }
        }
        onBackClick()
        return rootView
    }

    private fun onBackClick() {
        binding.bckButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_mainFragment)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}