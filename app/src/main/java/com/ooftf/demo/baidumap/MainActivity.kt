package com.ooftf.demo.baidumap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.baidu.mapapi.model.LatLng
import com.baidu.mapapi.search.core.SearchResult
import com.baidu.mapapi.search.geocode.*
import com.ooftf.basic.utils.toast
import com.ooftf.log.JLog

class MainActivity : AppCompatActivity() {
    //反向地理解析，获取周边poi 一定要尽早的初始化，不然搜索结果有可能出现 PERMISSION_UNFINISHED

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