package com.ferrero.appl.kcxuhd

import android.annotation.SuppressLint
import android.provider.MediaStore

import android.app.Activity
import android.content.Context

import java.io.IOException
import android.widget.Toast
import android.util.Log
import android.webkit.*


import com.appsflyer.AppsFlyerLib
import com.onesignal.OneSignal

import android.content.Intent


import android.content.pm.PackageManager
import android.net.Uri
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import com.ferrero.appl.Joposijxiz
import com.ferrero.appl.Joposijxiz.Companion.nnnvcvcijcv
import com.ferrero.appl.R
import com.ferrero.appl.databinding.ActivityKicuygdsBinding


import org.json.JSONException

import org.json.JSONObject

import java.io.File


class Stsuuhxhuc : AppCompatActivity() {
    lateinit var cuivhxu: WebView
    private val sodksjijisdsjid = 1
    var fijcxi: String? = null
    var jcnxvixchud: ValueCallback<Array<Uri>>? = null
    lateinit var fiudjidjfi: ActivityKicuygdsBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fiudjidjfi = ActivityKicuygdsBinding.inflate(layoutInflater)
        cuivhxu = WebView(this)
        setContentView(cuivhxu)


        val dfijsdfjisdfji = CookieManager.getInstance()
        dfijsdfjisdfji.setAcceptCookie(true)
        dfijsdfjisdfji.setAcceptThirdPartyCookies(cuivhxu, true)
        ivuccvyyggysd()
        val cuhvxucv: Activity = this
        cuivhxu.webViewClient = object : WebViewClient() {


            override fun shouldOverrideUrlLoading(fokfdjiijcxjic: WebView, diosjisd: String): Boolean {
                try {
                    if (URLUtil.isNetworkUrl(diosjisd)) {
                        return false
                    }
                    if (roekjidjis(diosjisd)) {

                        val mckxvijxcvhusd = Intent(Intent.ACTION_VIEW)
                        mckxvijxcvhusd.data = Uri.parse(diosjisd)
                        startActivity(mckxvijxcvhusd)
                    } else {

                        Toast.makeText(
                            applicationContext,
                            "Application is not installed",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=org.telegram.messenger")
                            )
                        )
                    }
                    return true
                } catch (e: Exception) {
                    return false
                }
                fokfdjiijcxjic.loadUrl(diosjisd)
            }


            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)

                xijzci(url)
            }

            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) {
                Toast.makeText(cuhvxucv, description, Toast.LENGTH_SHORT).show()
            }


        }
        cuivhxu.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                ijxjis: WebView, oosnjcxjicxji: ValueCallback<Array<Uri>>,
                rioejidji: FileChooserParams
            ): Boolean {
                jcnxvixchud?.onReceiveValue(null)
                jcnxvixchud = oosnjcxjicxji
                var ncjcxuvxcvh: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (ncjcxuvxcvh!!.resolveActivity(packageManager) != null) {

                    var eoijidjis: File? = null
                    try {
                        eoijidjis = forijejd()
                        ncjcxuvxcvh.putExtra("PhotoPath", fijcxi)
                    } catch (ex: IOException) {

                    }

                    if (eoijidjis != null) {
                        fijcxi = "file:" + eoijidjis.absolutePath
                        ncjcxuvxcvh.putExtra(
                            MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(eoijidjis)
                        )
                    } else {
                        ncjcxuvxcvh = null
                    }
                }
                val mmcxxcijxcjuhd = Intent(Intent.ACTION_GET_CONTENT)
                mmcxxcijxcjuhd.addCategory(Intent.CATEGORY_OPENABLE)
                mmcxxcijxcjuhd.type = "image/*"
                val fuhjdsji: Array<Intent?> =
                    ncjcxuvxcvh?.let { arrayOf(it) } ?: arrayOfNulls(0)
                val mckxkcxjhdgysgysdgyds = Intent(Intent.ACTION_CHOOSER)
                mckxkcxjhdgysgysdgyds.putExtra(Intent.EXTRA_INTENT, mmcxxcijxcjuhd)
                mckxkcxjhdgysgysdgyds.putExtra(Intent.EXTRA_TITLE, getString(R.string.file_chooser_title))
                mckxkcxjhdgysgysdgyds.putExtra(Intent.EXTRA_INITIAL_INTENTS, fuhjdsji)
                startActivityForResult(
                    mckxkcxjhdgysgysdgyds, sodksjijisdsjid
                )
                return true
            }

            @Throws(IOException::class)
            private fun forijejd(): File {
                var lxcoxcijxcuhu = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                    "DirectoryNameHere"
                )
                if (!lxcoxcijxcuhu.exists()) {
                    lxcoxcijxcuhu.mkdirs()
                }

                lxcoxcijxcuhu =
                    File(lxcoxcijxcuhu.toString() + File.separator + "IMG_" + System.currentTimeMillis() + ".jpg")
                return lxcoxcijxcuhu
            }

        }

        cuivhxu.loadUrl(toifdjihuuh())
    }


    private var icvjvhucuchd = false
    override fun onBackPressed() {


        if (cuivhxu.canGoBack()) {
            if (icvjvhucuchd) {
                cuivhxu.stopLoading()
                cuivhxu.loadUrl(doekjfi)
            }
            this.icvjvhucuchd = true
            cuivhxu.goBack()
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                icvjvhucuchd = false
            }, 2000)

        } else {
            super.onBackPressed()
        }
    }



    private fun toifdjihuuh(): String {

        val uihubvhubuc = getSharedPreferences("SHARED_PREF",
            Context.MODE_PRIVATE)


        val mmcmxkcivuuuuuudysysdys = "com.ferrero.appl"
        val roejiidjijsf = intent.getStringExtra("WebInt")
        val fijid = "deviceID="
        val qopwokowko = "sub_id_1="

        val sokd = "sub_id_4="
        val ijxczi = "ad_id="
        val qowij = Build.VERSION.RELEASE



        val okjidijs = "sub_id_6="
        val nnnvccvcvji = "sub_id_5="
        val mcxkvijidjisjivsdhuvsd = getSharedPreferences(Joposijxiz.vuchubc, MODE_PRIVATE)
        val bcvuvhuccv = "naming"

        val qowoksji = "deeporg"
        val bvocvkkovbcjijibv= getSharedPreferences(Joposijxiz.wiooowsodk, MODE_PRIVATE)
        val eijr= getSharedPreferences(Joposijxiz.orkodjifji, MODE_PRIVATE)
        val ozixjjizxhu= getSharedPreferences(Joposijxiz.pppsoosdkdsoa, MODE_PRIVATE)


        val mckvji = uihubvhubuc.getString(Joposijxiz.bvcjbi, null)
        val eojirjid: String? = uihubvhubuc.getString(nnnvcvcijcv, null)
        val cijjijicjivxhucxv = AppsFlyerLib.getInstance().getAppsFlyerUID(this)
        AppsFlyerLib.getInstance().setCollectAndroidID(true)


        val dosksd:String? = eijr.getString(Joposijxiz.orkodjifji,"null")
        val nncxcxijjicx: String? = bvocvkkovbcjijibv.getString(Joposijxiz.wiooowsodk,"null")
        val ofodkidjfif: String? = mcxkvijidjisjivsdhuvsd.getString(Joposijxiz.vuchubc,"null")



        val tryduhdsf = ozixjjizxhu.getString(Joposijxiz.pppsoosdkdsoa,"null")

        var viivjcuh = ""
        when (roejiidjijsf) {
            "MT" -> {
                viivjcuh =
                    "$tryduhdsf$fijid$mckvji&$ijxczi$eojirjid&$sokd$mmcmxkcivuuuuuudysysdys&$nnnvccvcvji$qowij&$okjidijs$bcvuvhuccv"
                foriejieji(mckvji.toString())
                Log.d("TESTAG", "urururururururur tracker: $viivjcuh")
            }
            "deepLink" -> {
                viivjcuh =
                    "$tryduhdsf$qopwokowko$nncxcxijjicx&$fijid$cijjijicjivxhucxv&$ijxczi$ofodkidjfif&$sokd$mmcmxkcivuuuuuudysysdys&$nnnvccvcvji$qowij&$okjidijs$qowoksji"
                foriejieji(mckvji.toString())
                Log.d("TESTAG", "urururururururur deep: $viivjcuh")
            }
            "campaign" -> {
                viivjcuh =
                    "$tryduhdsf$qopwokowko$dosksd&$fijid$cijjijicjivxhucxv&$ijxczi$ofodkidjfif&$sokd$mmcmxkcivuuuuuudysysdys&$nnnvccvcvji$qowij&$okjidijs$bcvuvhuccv"
                foriejieji(cijjijicjivxhucxv.toString())
                Log.d("TESTAG", "urururururururur apps: $viivjcuh")
            }
        }

        Log.d("TESTAG", "Test Result $viivjcuh")
        return uihubvhubuc.getString("SAVED_URL", viivjcuh).toString()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun ivuccvyyggysd() {
        val apaoskjsai = cuivhxu.settings
        apaoskjsai.pluginState = WebSettings.PluginState.ON
        apaoskjsai.domStorageEnabled = true
        apaoskjsai.setAppCacheEnabled(true)

        apaoskjsai.allowContentAccess = true
        apaoskjsai.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        apaoskjsai.loadWithOverviewMode = true
        apaoskjsai.setSupportMultipleWindows(false)
        apaoskjsai.userAgentString = apaoskjsai.userAgentString.replace("; wv", "")
        apaoskjsai.builtInZoomControls = true
        apaoskjsai.setSupportZoom(true)


        apaoskjsai.allowFileAccess = true
        apaoskjsai.useWideViewPort = true
        apaoskjsai.displayZoomControls = false
        apaoskjsai.javaScriptCanOpenWindowsAutomatically = true
        apaoskjsai.javaScriptEnabled = true

    }


    var doekjfi = ""
    fun xijzci(sokd: String?) {
        if (!sokd!!.contains("t.me")) {

            if (doekjfi == "") {
                doekjfi = getSharedPreferences(
                    "SHARED_PREF",
                    AppCompatActivity.MODE_PRIVATE
                ).getString(
                    "SAVED_URL",
                    sokd
                ).toString()

                val obkvji = getSharedPreferences("SHARED_PREF", AppCompatActivity.MODE_PRIVATE)
                val rokod = obkvji.edit()
                rokod.putString("SAVED_URL", sokd)
                rokod.apply()
            }
        }
    }


    private fun foriejieji(vicjcijv: String) {
        OneSignal.setExternalUserId(
            vicjcijv,
            object : OneSignal.OSExternalUserIdUpdateCompletionHandler {
                override fun onSuccess(mkcvuuuds: JSONObject) {
                    try {
                        if (mkcvuuuds.has("push") && mkcvuuuds.getJSONObject("push").has("success")) {
                            val eiwiqij = mkcvuuuds.getJSONObject("push").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for push status: $eiwiqij"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (mkcvuuuds.has("email") && mkcvuuuds.getJSONObject("email").has("success")) {
                            val ixzjuhsa =
                                mkcvuuuds.getJSONObject("email").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for email status: $ixzjuhsa"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (mkcvuuuds.has("sms") && mkcvuuuds.getJSONObject("sms").has("success")) {
                            val jcxijcviudh = mkcvuuuds.getJSONObject("sms").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for sms status: $jcxijcviudh"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

                override fun onFailure(error: OneSignal.ExternalIdError) {
                    OneSignal.onesignalLog(
                        OneSignal.LOG_LEVEL.VERBOSE,
                        "Set external user id done with error: $error"
                    )
                }
            })
    }

    private fun roekjidjis(ncxijxc: String): Boolean {

        val ppasokd = packageManager
        try {

            ppasokd.getPackageInfo("org.telegram.messenger", PackageManager.GET_ACTIVITIES)

            return true
        } catch (e: PackageManager.NameNotFoundException) {

        }
        return false
    }




    override fun onActivityResult(ivijcvb: Int, osodkajiasdji: Int, okocijijcvji: Intent?) {
        if (ivijcvb != sodksjijisdsjid || jcnxvixchud == null) {
            super.onActivityResult(ivijcvb, osodkajiasdji, okocijijcvji)
            return
        }
        var orijjdisjif: Array<Uri>? = null


        if (osodkajiasdji == AppCompatActivity.RESULT_OK) {
            if (okocijijcvji == null || okocijijcvji.data == null) {

                orijjdisjif = arrayOf(Uri.parse(fijcxi))
            } else {
                val nnmcvicvj = okocijijcvji.dataString
                if (nnmcvicvj != null) {
                    orijjdisjif = arrayOf(Uri.parse(nnmcvicvj))
                }
            }
        }
        jcnxvixchud?.onReceiveValue(orijjdisjif)
        jcnxvixchud = null
    }







}