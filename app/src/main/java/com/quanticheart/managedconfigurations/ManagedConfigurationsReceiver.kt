package com.quanticheart.managedconfigurations

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle

/**
 * Restrictions receiver
 *
 * Observação: a ACTION_APPLICATION_RESTRICTIONS_CHANGED intenção é enviada apenas para ouvintes
 * registrados dinamicamente, não para ouvintes declarados no manifesto do aplicativo.
 */
private var restrictionsReceiver: BroadcastReceiver? = null
fun Activity.registerRestrictionsFilter(callback: (Bundle) -> Unit) {
    val restrictionsFilter = IntentFilter(Intent.ACTION_APPLICATION_RESTRICTIONS_CHANGED)
    restrictionsReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            // Get the current configuration bundle
            val appRestrictions = getRestrictionsManager()
            callback(appRestrictions)
        }
    }
    registerReceiver(restrictionsReceiver, restrictionsFilter)
}

fun Activity.unregisterRestrictionsFilter() {
    unregisterReceiver(restrictionsReceiver)
}
