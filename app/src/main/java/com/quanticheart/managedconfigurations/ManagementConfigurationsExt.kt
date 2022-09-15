package com.quanticheart.managedconfigurations

import android.content.Context
import android.content.RestrictionsManager
import android.os.Bundle

//
// Created by Jonn Alves on 15/09/22.
//
fun Context.getRestrictionsManager(): Bundle {
    val myRestrictionsMgr =
        getSystemService(Context.RESTRICTIONS_SERVICE) as RestrictionsManager
    return myRestrictionsMgr.applicationRestrictions
}

fun Context.getImei(): String? {
    val appRestrictions = getRestrictionsManager()
    return if (appRestrictions.containsKey("imei")) {
        appRestrictions.getString("imei")
    } else null
}