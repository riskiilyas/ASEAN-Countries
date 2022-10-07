package com.keecoding.aseancountries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import com.keecoding.aseancountries.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var country: Country

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        country = Country(
            intent.getStringExtra(Constants.COUNTRY) ?: "Null",
            intent.getIntExtra(Constants.IMAGE_SRC, R.drawable.indonesia),
            intent.getStringExtra(Constants.JOINED_DATE) ?: "Null",
            intent.getStringExtra(Constants.DESCRIPTION) ?: "Null",
        )

        binding.apply {
            ivCountry.setImageResource(country.src)
            tvDesc.text = country.description
            tvJoined.text = country.joinedDate
            tvCountry.text = country.name
            tvDesc.movementMethod = ScrollingMovementMethod()
        }

    }
}