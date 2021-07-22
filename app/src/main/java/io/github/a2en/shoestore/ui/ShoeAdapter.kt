package io.github.a2en.shoestore.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.a2en.shoestore.databinding.ShoeItemBinding
import io.github.a2en.shoestore.model.Shoe

class ShoeAdapter(val list:List<Shoe>):RecyclerView.Adapter<ShoeAdapter.ViewHolder>() {

    inner class ViewHolder(var binding:ShoeItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ShoeItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.name.text = item.name
        holder.binding.company.text = item.company
        holder.binding.size.text = item.size
        holder.binding.description.text = item.description
    }

    override fun getItemCount()=list.size
}