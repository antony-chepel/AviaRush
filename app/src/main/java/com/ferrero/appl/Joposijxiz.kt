package com.ferrero.appl

import android.app.Application
import android.content.Context
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import java.util.*

class Joposijxiz : Application() {
    companion object {
        const val bvncibjcvb = "732a051d-9864-469d-823b-dfbca83ccd5f"
        var nnnvcvcijcv: String? = "instID"
        var wiooowsodk: String? = "d11"
        var suidajiaisjdasuh = "appsChecker"

        val rokodkkfokoasf = "ViaFdgFFdNeWTQaJaNbwzN"
        var orkodjifji: String? = "c11"
        var vuchubc: String? = "main_id"

        var pppsoosdkdsoa = "link"
        val bvcjbi: String = "myID"



    }

    override fun onCreate() {
        super.onCreate()
        OneSignal.initWithContext(this)
        OneSignal.setAppId(bvncibjcvb)


        val gofj = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val qowwkokosakod = getSharedPreferences("PREFS_NAME", 0)

        val nnvbuivbbjiv = MyTracker.getTrackerParams()
        val reyyuds = MyTracker.getTrackerConfig()
        val mmmkxcixcjx = MyTracker.getInstanceId(this)
        reyyuds.isTrackingLaunchEnabled = true
        val xspokjixs = UUID.randomUUID().toString()

        if (qowwkokosakod.getBoolean("my_first_time", true)) {
            nnvbuivbbjiv.setCustomUserId(xspokjixs)
            gofj.edit().putString(bvcjbi, xspokjixs).apply()
            gofj.edit().putString(nnnvcvcijcv, mmmkxcixcjx).apply()
            qowwkokosakod.edit().putBoolean("my_first_time", false).apply()
        } else {
            val mkijcuhx = gofj.getString(bvcjbi, xspokjixs)
            nnvbuivbbjiv.setCustomUserId(mkijcuhx)
        }
        MyTracker.initTracker("04752473935712921889", this)
    }
}