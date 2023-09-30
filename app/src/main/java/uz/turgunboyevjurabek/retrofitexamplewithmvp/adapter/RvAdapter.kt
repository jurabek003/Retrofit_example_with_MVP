package uz.turgunboyevjurabek.retrofitexamplewithmvp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import okhttp3.internal.notifyAll
import uz.turgunboyevjurabek.retrofitexamplewithmvp.databinding.ItemRvBinding
import uz.turgunboyevjurabek.retrofitexamplewithmvp.madels.GetClinets

class RvAdapter(val list:ArrayList<GetClinets>):RecyclerView.Adapter<RvAdapter.Vh>() {
    inner class Vh(val itemRvBinding: ItemRvBinding):ViewHolder(itemRvBinding.root){
        fun onBind(getClinets: GetClinets){
            itemRvBinding.itemAddress.text=getClinets.manzil
            itemRvBinding.itemName.text=getClinets.ism
            itemRvBinding.itemLastName.text=getClinets.fam
            itemRvBinding.itemSumma.text=getClinets.umumiySumma.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int =list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

}