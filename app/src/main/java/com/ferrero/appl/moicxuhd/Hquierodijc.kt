package com.ferrero.appl.moicxuhd

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.facebook.share.Share
import com.ferrero.appl.databinding.ActivityHquierodijcBinding
import com.ferrero.appl.kcxuhd.Deooijdsijijxc

class Hquierodijc : AppCompatActivity() {
    private lateinit var sharedName : SharedPreferences
    private lateinit var uidfdsji : ActivityHquierodijcBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        uidfdsji = ActivityHquierodijcBinding.inflate(layoutInflater)
        setContentView(uidfdsji.root)
        sharedName = getSharedPreferences("NAME_AV_RUSH", MODE_PRIVATE)
        nnvcijcvhu()
    }


    private fun nnvcijcvhu() = with(uidfdsji){
        qowijids.setOnClickListener {
            val viocbjv = ovckjivcb.text.toString()

            if(viocbjv.isEmpty() || viocbjv.length<3){
                ofofkcjicxi.visibility = View.VISIBLE

            } else {
                sharedName.edit().putString("NAME_AV_RUSH",viocbjv).apply()
                startActivity(
                    Intent(this@Hquierodijc, Tqoisijxhuzhu::class.java))
                ofofkcjicxi.visibility = View.GONE
                ovckjivcb.text.clear()
                ovckjivcb.clearFocus()

            }

        }
        mkcoxoxcixcji.setOnClickListener {
            startActivity(Intent(this@Hquierodijc,Deooijdsijijxc::class.java))
        }
        button3.setOnClickListener {
            finish()
        }


    }
}