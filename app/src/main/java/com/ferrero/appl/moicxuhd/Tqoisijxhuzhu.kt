package com.ferrero.appl.moicxuhd

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import com.ferrero.appl.databinding.ActivityTqoisijxhuzhuBinding
import com.ferrero.appl.kcxuhd.Ceosizji

class Tqoisijxhuzhu : AppCompatActivity() {
    private var eooodksko = 0
    private var bonuses = 100
    private lateinit var kxzcijs : ActivityTqoisijxhuzhuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kxzcijs = ActivityTqoisijxhuzhuBinding.inflate(layoutInflater)
        setContentView(kxzcijs.root)
        kxzcijs.ovkbv.progress = eooodksko
        rojidijf()
        kxzcijs.button2.setOnClickListener {
            startActivity(Intent(this,Ceosizji::class.java)
                .putExtra("pwr",eooodksko)
                .putExtra("bonuses",bonuses)
            )
        }

    }


    @SuppressLint("ClickableViewAccessibility")
    private fun rojidijf() = with(kxzcijs){
        imMain.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, sdsoksd: MotionEvent?): Boolean {
                if(sdsoksd?.action == MotionEvent.ACTION_DOWN) {
                    eooodksko +=10
                    bonuses -=10
                    odijf.text = "$eooodksko"
                    if(eooodksko >= 100){
                        eooodksko = 0
                        odijf.text = "$eooodksko"
                    }
                    if(bonuses <= 0){
                        bonuses = 100
                        odijf.text = "$eooodksko"
                        iocxjixji.text = "Avia Bonus Scores : x$bonuses"
                    }
                    iocxjixji.text = "Avia Bonus Scores : x$bonuses"
                    ovkbv.progress = eooodksko


                    v?.animate()?.scaleX(0.99f)?.scaleY(0.99f)?.setDuration(0)
                } else if(sdsoksd?.action == MotionEvent.ACTION_UP){
                    v?.animate()?.scaleX(1.0f)?.scaleY(1.0f)?.setDuration(0)
                }

                return true
            }

        })
    }
}