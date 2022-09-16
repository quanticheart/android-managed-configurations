package com.quanticheart.managedconfigurations

import android.content.Context
import android.content.RestrictionEntry
import android.content.RestrictionsManager
import android.os.Bundle

//
// Created by Jonn Alves on 15/09/22.
//
fun Context.getRestrictionsManager(): Bundle? {
    val myRestrictionsMgr =
        getSystemService(Context.RESTRICTIONS_SERVICE) as RestrictionsManager
    return myRestrictionsMgr.applicationRestrictions
}

fun Context.getRestrictionsManagerDebug(): MutableList<RestrictionEntry>? {
    return try {
        val myRestrictionsMgr =
            getSystemService(Context.RESTRICTIONS_SERVICE) as RestrictionsManager
        myRestrictionsMgr.getManifestRestrictions(packageName)
    } catch (e: Exception) {
        null
    }
}

fun Context.getImei(): String? {
    return getRestrictionsManager()?.let {
        if (it.containsKey("imei")) {
            it.getString("imei")
        } else null
    }
}