package com.ooftf.demo.baidumap

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.baidu.mapapi.model.LatLng
import com.baidu.mapapi.search.core.SearchResult
import com.baidu.mapapi.search.geocode.*
import com.ooftf.log.JLog

class MainActivity : AppCompatActivity() {
    //反向地理解析，获取周边poi 一定要尽早的初始化，不然搜索结果有可能出现 PERMISSION_UNFINISHED
    val mGeoCoder = GeoCoder.newInstance().apply {
        setOnGetGeoCodeResultListener(object : OnGetGeoCoderResultListener {
            override fun onGetGeoCodeResult(p0: GeoCodeResult) {
                JLog.eJson("onGetGeoCodeResult",p0)
            }

            override fun onGetReverseGeoCodeResult(p0: ReverseGeoCodeResult) {
                if (p0.error == SearchResult.ERRORNO.PERMISSION_UNFINISHED) {
                    reverse()
                }
                JLog.eJson("onGetReverseGeoCodeResult",p0)
            }
        })
    }


    //rQVMa8ofkcTFDbfklgoQweGWBnj6l0ll
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.show).setOnClickListener {

        }
        findViewById<View>(R.id.stop).setOnClickListener {

        }
        findViewById<View>(R.id.start).setOnClickListener {

        }
        findViewById<View>(R.id.reStart).setOnClickListener {
            reverse()
        }

        findViewById<View>(R.id.request).setOnClickListener {

        }
        /*{
            "latitude": 39.966885072803535,
            "latitudeE6": 3.9966885072803535E7,
            "longitude": 116.30896899999993,
            "longitudeE6": 1.1630896899999994E8
        }*/
        reverse()
    }

    private fun reverse() {
        mGeoCoder.reverseGeoCode(ReverseGeoCodeOption().apply {
            newVersion(1)
                .pageNum(0)
                .pageSize(20)
            location(LatLng(39.966885072803535, 116.30896899999993))
        })
    }
}