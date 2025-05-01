package com.example.flutter_method_channel

import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterActivity() {

    private val channel = "battery_channel"

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(
            flutterEngine.dartExecutor.binaryMessenger,
            channel
        ).setMethodCallHandler { call, result ->

            if (call.method == "getBatteryLevel") {
                result.success(getBatteryLevel())
            } else {
                result.error("error code", "error message", "error details")
            }

        }


    }

    private fun getBatteryLevel(): Int {
        val intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        val intent: Intent? = context.registerReceiver(null, intentFilter)

        if (intent != null) {
            return intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
        }
        return -1;
    }
}