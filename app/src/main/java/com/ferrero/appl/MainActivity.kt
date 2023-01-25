package com.ferrero.appl

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.ferrero.appl.vducyxis.Gtsuhxij
import com.ferrero.appl.kcxuhd.Stsuuhxhuc
import com.ferrero.appl.moicxuhd.Hquierodijc
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private val sisdsijda: Gtsuhxij by viewModels()
    private lateinit var mvccvijcvi : SharedPreferences
    private lateinit var reyuhsdahuhudshusd : SharedPreferences
    private lateinit var mcxijcijcv : SharedPreferences

    private lateinit var eiwjiijsjiad : SharedPreferences
    private lateinit var nijdisd : SharedPreferences
    var fjdidfji: String = ""
    var ncxvhuvxchu: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nijdisd = getSharedPreferences(Joposijxiz.suidajiaisjdasuh, MODE_PRIVATE)
        eiwjiijsjiad = getSharedPreferences(Joposijxiz.pppsoosdkdsoa, MODE_PRIVATE)
        mvccvijcvi = getSharedPreferences(Joposijxiz.vuchubc, MODE_PRIVATE)
        reyuhsdahuhudshusd= getSharedPreferences(Joposijxiz.wiooowsodk, MODE_PRIVATE)
        mcxijcijcv= getSharedPreferences(Joposijxiz.orkodjifji, MODE_PRIVATE)
        lifecycleScope.launch {
            sisdsijda.bnbivvbuh(this@MainActivity)
            AppsFlyerLib.getInstance()
                .init(Joposijxiz.rokodkkfokoasf, bivjihuhvuchu, applicationContext)
            AppsFlyerLib.getInstance().start(this@MainActivity)
        }


        gfuruijiejif()
    }



    val bivjihuhvuchu = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val firejif = data?.get("campaign").toString()
            mcxijcijcv.edit().putString(Joposijxiz.orkodjifji,firejif).apply()
        }

        override fun onConversionDataFail(p0: String?) {
            Log.e("dev_test", "error getting conversion data: $p0" );
        }

        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {

        }

        override fun onAttributionFailure(p0: String?) {
        }
    }

    private fun wiwiisusdhsdu() {
        lifecycleScope.launch(Dispatchers.IO) {
            val ncxvhu = Intent(this@MainActivity, Stsuuhxhuc::class.java)
            val tdusah = nijdisd.getString(Joposijxiz.suidajiaisjdasuh,"null")
            var kiicjxv: String? = mcxijcijcv.getString(Joposijxiz.orkodjifji,"null")
            val bvvccvcji: String? = reyuhsdahuhudshusd.getString(Joposijxiz.wiooowsodk,"null")
            val kkksidjsadji = Executors.newSingleThreadScheduledExecutor()
            tuciixcj()
            if (tdusah == "1") {
                kkksidjsadji.scheduleAtFixedRate({
                    if (kiicjxv != null) {
                        if (kiicjxv!!.contains("tdb2") && bvvccvcji!!.contains(
                                "tdb2"
                            )
                        ) {
                            kkksidjsadji.shutdown()
                            ncxvhu.putExtra("WebInt", "campaign")
                            startActivity(ncxvhu)
                            finish()


                        } else if(kiicjxv!!.contains("tdb2") || fjdidfji.contains(ncxvhuvxchu)){
                            kkksidjsadji.shutdown()
                            ncxvhu.putExtra("WebInt", "campaign")
                            startActivity(ncxvhu)
                            finish()
                        } else if(!kiicjxv!!.contains("tdb2") && bvvccvcji!!.contains(
                                "tdb2"
                            )){
                            kkksidjsadji.shutdown()
                            ncxvhu.putExtra("WebInt", "deepLink")
                            startActivity(ncxvhu)
                            finish()

                        } else {
                            kkksidjsadji.shutdown()
                            startActivity(Intent(this@MainActivity, Hquierodijc::class.java))
                            finish()
                        }
                    } else {
                        kiicjxv = mcxijcijcv.getString(Joposijxiz.orkodjifji,"null")
                    }
                }, 0, 2, TimeUnit.SECONDS)
            } else {
                if(bvvccvcji!!.contains(
                        "tdb2")){
                    ncxvhu.putExtra("WebInt", "deepLink")
                    startActivity(ncxvhu)
                    finish()
                } else if(fjdidfji.contains(ncxvhuvxchu)){
                    ncxvhu.putExtra("WebInt", "MT")
                    startActivity(ncxvhu)
                    finish()
                }else{
                    startActivity(Intent(this@MainActivity, Hquierodijc::class.java))
                    finish()
                }

            }

        }
    }

    private fun gfuruijiejif(){
        sisdsijda.icjixvhuhduhvshu()
        sisdsijda.jocxicjxjx.observe(this,{
            ncxvhuvxchu =  it.ncxuhvuxc
            sisdsijda.vifijjif()
            sisdsijda.rseasyasyg.observe(this,{
                val uicxjiz = it.rijeijisdhuhx
                fjdidfji = it.ibuvh
                val oosooosisisias = it.mxkzocjsahushuac
                nijdisd.edit().putString(Joposijxiz.suidajiaisjdasuh,oosooosisisias).apply()
                eiwjiijsjiad.edit().putString(Joposijxiz.pppsoosdkdsoa,uicxjiz).apply()
                wiwiisusdhsdu()

            })

        })



    }

    private fun tuciixcj() {
        val lllxoozcji = AdvertisingIdClient(applicationContext)
        lllxoozcji.start()
        val wqoks = lllxoozcji.info.id
        mvccvijcvi.edit().putString(Joposijxiz.vuchubc,wqoks).apply()
    }


}