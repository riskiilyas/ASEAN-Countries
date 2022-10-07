package com.keecoding.aseancountries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.keecoding.aseancountries.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = CountryAdapter {
            showToast("${it.name} dipilih!")
            goto(DetailActivity::class.java, it)
        }

        binding.rvCountry.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.topbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.aboutMenu -> {
                goto(AboutActivity::class.java)
                true
            }

            R.id.menuExit -> {
                finish()
                true
            }

            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}