package com.keecoding.aseancountries

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.keecoding.aseancountries.databinding.CountryLayoutBinding

class CountryAdapter(
    private val onCountryClicked: (Country) -> Unit
): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    inner class CountryViewHolder(private val binding: CountryLayoutBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(country: Country) {
            binding.root.setOnClickListener { onCountryClicked(country) }

            binding.tvCountry.text = country.name
            binding.ivFlag.setImageResource(country.src)
            binding.tvJoined.text = country.joinedDate
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = CountryLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(Constants.COUNTRIES[position])
    }

    override fun getItemCount() = Constants.COUNTRIES.size

}