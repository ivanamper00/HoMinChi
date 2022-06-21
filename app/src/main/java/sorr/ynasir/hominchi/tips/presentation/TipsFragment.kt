package sorr.ynasir.hominchi.tips.presentation

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.AppBarLayout
import sorr.ynasir.hominchi.R
import sorr.ynasir.hominchi.databinding.FragmentTipsBinding
import sorr.ynasir.hominchi.tips.adapter.TipsAdapter
import sorr.ynasir.hominchi.tips.model.TipsInterface
import sorr.ynasir.hominchi.tips.model.TipsModel

class TipsFragment : Fragment() , TipsInterface {

    private var _binding : FragmentTipsBinding? = null
    private val  binding get() = _binding!!
    private var tipsData = TipsViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

         _binding = FragmentTipsBinding.inflate(inflater,container,false)
        val rootView = binding.root
        tipsData = ViewModelProvider(this)[TipsViewModel::class.java]

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

        tipsData.tipsFun()
        val adpts = TipsAdapter(this)
        tipsData.tpsdtls.observe(viewLifecycleOwner){
            if(it != null){
                adpts.setAdapter(it)
                    binding.tipsRecycler.apply {
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
            findNavController().navigate(R.id.action_tipsFragment_to_mainFragment)
        }
    }
    override fun onClickitem(data: TipsModel) {
        var dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.tips_show_all)
        dialog.setCancelable(true)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        var title = dialog.findViewById<TextView>(R.id.tips_title_view_all)
        var desc = dialog.findViewById<TextView>(R.id.tips_desc_view_all)

        title.text = data.tipsT
        desc.text = data.tipsD

        dialog.show()
    }
}