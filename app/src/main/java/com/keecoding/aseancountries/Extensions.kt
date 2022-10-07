package com.keecoding.aseancountries

import android.content.Context
import android.content.Intent
import android.widget.Toast

fun <T> Context.goto(destClass: Class<T>, country: Country? = null) {
    val mIntent = Intent(this, destClass)
    country?.let {
        mIntent.putExtra(Constants.COUNTRY, country.name)
        mIntent.putExtra(Constants.JOINED_DATE, country.joinedDate)
        mIntent.putExtra(Constants.IMAGE_SRC, country.src)
        mIntent.putExtra(Constants.DESCRIPTION, country.description)
    }
    startActivity(Intent(mIntent))
}

fun Context.showToast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, duration).show()
}