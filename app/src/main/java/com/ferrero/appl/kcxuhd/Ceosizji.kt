package com.ferrero.appl.kcxuhd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import androidx.core.content.ContextCompat
import com.ferrero.appl.R
import com.ferrero.appl.databinding.ActivityCeosizjiBinding
import com.ferrero.appl.vducyxis.Fwwishuadu
import kotlin.random.Random

class Ceosizji : AppCompatActivity() {
    private var dijsasjid: CountDownTimer? = null
    var scoreValue = 2
    private lateinit var mixozuh : ActivityCeosizjiBinding
    val lsudh = listOf(
        R.drawable.av_rush_it_1,
        R.drawable.av_rush_it_2,
        R.drawable.av_rush_it_3,
        R.drawable.av_rush_it_4,
        R.drawable.av_rush_it_5,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mixozuh = ActivityCeosizjiBinding.inflate(layoutInflater)
        setContentView(mixozuh.root)
        mixozuh.button4.setOnClickListener {
            doskfji()
        }

    }

    private fun doskfji() = with(mixozuh){
        var odkdfo = 0
        dijsasjid?.cancel()
        dijsasjid = object : CountDownTimer(3000,100){
            override fun onTick(millisUntilFinished: Long) {
                odkdfo++
                button4.isClickable = false
                button4.alpha = 0.7f
                if(odkdfo>4)odkdfo = 0
                coxcojicxv.setImageResource(lsudh[odkdfo])


            }

            override fun onFinish() {
                 isayudgysa()
                button4.isClickable = false
                button4.alpha = 1.0f

            }

        }.start()
    }

    private fun  isayudgysa() = with(mixozuh){
        val setImage  = lsudh[Random.nextInt(5)]
        coxcojicxv.setImageResource(setImage)
        val pwrl = intent.getIntExtra("pwr",0)
        val bonuses = intent.getIntExtra("bonuses",0)
        val plural = pwrl + bonuses

        if(coxcojicxv.drawable.constantState == ContextCompat.getDrawable(this@Ceosizji, R.drawable.av_rush_it_1)?.constantState){
            scoreValue = 2 *plural
            Handler().postDelayed({
                startActivity(Intent(this@Ceosizji,Fwwishuadu::class.java)
                    .putExtra("total",scoreValue)
                )
            },1500)
        }
        if(coxcojicxv.drawable.constantState == ContextCompat.getDrawable(this@Ceosizji, R.drawable.av_rush_it_2)?.constantState){
            scoreValue = 3 *plural
            Handler().postDelayed({
                startActivity(Intent(this@Ceosizji,Fwwishuadu::class.java)
                    .putExtra("total",scoreValue)
                )
            },1500)
        }
        if(coxcojicxv.drawable.constantState == ContextCompat.getDrawable(this@Ceosizji, R.drawable.av_rush_it_3)?.constantState){
            scoreValue = 4 *plural
            Handler().postDelayed({
                startActivity(Intent(this@Ceosizji,Fwwishuadu::class.java)
                    .putExtra("total",scoreValue)
                )
            },1500)
        }

        if(coxcojicxv.drawable.constantState == ContextCompat.getDrawable(this@Ceosizji, R.drawable.av_rush_it_4)?.constantState){
            scoreValue = 5 *plural
            Handler().postDelayed({
                startActivity(Intent(this@Ceosizji,Fwwishuadu::class.java)
                    .putExtra("total",scoreValue)
                )
            },1500)
        }
        if(coxcojicxv.drawable.constantState == ContextCompat.getDrawable(this@Ceosizji, R.drawable.av_rush_it_5)?.constantState){
            scoreValue = 10 *plural
            Handler().postDelayed({
                startActivity(Intent(this@Ceosizji,Fyusijxzuh::class.java)
                    .putExtra("total",scoreValue)
                )
            },1500)
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        dijsasjid?.cancel()
    }
}