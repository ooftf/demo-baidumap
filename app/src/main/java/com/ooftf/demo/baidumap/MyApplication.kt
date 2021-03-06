package com.ooftf.demo.baidumap

import android.app.Application
import com.baidu.mapapi.SDKInitializer
import com.ooftf.basic.utils.runMainProcess

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2021/6/4
 */
class MyApplication : Application() {
    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        //Director.init("b6a6080607d1a37310565aca1998e0e9", BuildConfig.DEBUG)
        runMainProcess {
            SDKInitializer.setApiKey("rQVMa8ofkcTFDbfklgoQweGWBnj6l0ll")
            SDKInitializer.initialize(this)
            //S.startLocation()
        }
    }

    companion object {
        lateinit var instance: MyApplication
    }
}