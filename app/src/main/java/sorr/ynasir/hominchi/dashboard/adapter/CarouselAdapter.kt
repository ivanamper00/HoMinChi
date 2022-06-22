package sorr.ynasir.hominchi.dashboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sorr.ynasir.hominchi.databinding.CarouselviewBinding

class CarouselAdapter(val dataImg : ArrayList<Int>): RecyclerView.Adapter<CarouselAdapter.AdapterHolder>() {

    class AdapterHolder (val adpts : CarouselviewBinding) : RecyclerView.ViewHolder(adpts.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHolder =
        AdapterHolder(
            CarouselviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: AdapterHolder, position: Int) {
        holder.adpts.apply {
            carouselPlaceholder.setBackgroundResource(dataImg[position])
        }
    }

    override fun getItemCount(): Int {
        return dataImg.size
    }
}