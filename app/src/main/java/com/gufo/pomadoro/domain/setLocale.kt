package com.gufo.pomadoro.domain

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import java.util.Locale

fun setLocale(context: Context, languageCode: String) {
    val locale = Locale(languageCode)
    Locale.setDefault(locale)
    val config = Configuration(context.resources.configuration)
    config.setLocale(locale)
    context.resources.updateConfiguration(config, context.resources.displayMetrics)
}


fun restartActivity(context: Context) {
    val intent = (context as? Activity)?.intent
    context.startActivity(intent)
    (context as? Activity)?.finish()
}