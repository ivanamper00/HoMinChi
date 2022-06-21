package sorr.ynasir.hominchi.guide.adapter

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sorr.ynasir.hominchi.databinding.GuideviewBinding
import sorr.ynasir.hominchi.guide.model.GuideInterface
import sorr.ynasir.hominchi.guide.model.GuideModel

class GuideAdapter(val listener : GuideInterface) : RecyclerView.Adapter<GuideAdapter.AdapterHolder>(){
    private var guideList = emptyList<GuideModel>()
    class AdapterHolder (val adpts : GuideviewBinding) : RecyclerView.ViewHolder(adpts.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHolder = AdapterHolder(
        GuideviewBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: AdapterHolder, position: Int) {
       with(holder){
           with(guideList[position]){
               adpts.guideTitle.text = this.guideT
               adpts.guideDesc.text = this.guideD
               adpts.guideDesc.ellipsize = TextUtils.TruncateAt.MARQUEE
               adpts.guideDesc.isSelected = true
               adpts.guideCardview.setOnClickListener {
                   listener.onItemClick(this)
               }
           }
       }
    }

    override fun getItemCount(): Int {
       return guideList.size
    }

    fun setAdapter (setAdapt : List<GuideModel>){
        this.guideList = setAdapt
    }
}