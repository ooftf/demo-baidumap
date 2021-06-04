package com.ooftf.demo.baidumap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ooftf.basic.utils.toast

class MainActivity : AppCompatActivity() {
    //rQVMa8ofkcTFDbfklgoQweGWBnj6l0ll
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.show).setOnClickListener {
            toast("" +S.locationClient.isStarted)
        }
        findViewById<View>(R.id.stop).setOnClickListener {
            S.locationClient.stop()
        }
        findViewById<View>(R.id.start).setOnClickListener {
            S.locationClient.start()
        }
        findViewById<View>(R.id.reStart).setOnClickListener {
            S.locationClient.restart()
        }

        findViewById<View>(R.id.request).setOnClickListener {
            S.locationClient.requestLocation()
        }
    }
}