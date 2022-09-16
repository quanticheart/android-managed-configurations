package com.quanticheart.managedconfigurations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.quanticheart.managedconfigurations.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.details.text = getRestrictionsManagerDebug()?.toString() ?: "NULL CONFIG"

        binding.imei.text = getImei() ?: "IMEI NULL"

        registerRestrictionsFilter { binding.imei.text = getImei() ?: "IMEI NULL" }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterRestrictionsFilter()
    }
}