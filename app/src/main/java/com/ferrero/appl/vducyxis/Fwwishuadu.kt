package com.ferrero.appl.vducyxis

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ferrero.appl.databinding.ActivityFwwishuaduBinding
import com.ferrero.appl.moicxuhd.Hquierodijc
import kotlin.random.Random

class Fwwishuadu : AppCompatActivity() {
    private lateinit var mvkcijuhds : ActivityFwwishuaduBinding
    private lateinit var shaoekd : SharedPreferences
    val lisgyds = listOf(
        300,
        500,
        600,
        800,
        1200,
        1500,
        2000,
        2500,
        5000
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mvkcijuhds = ActivityFwwishuaduBinding.inflate(layoutInflater)
        setContentView(mvkcijuhds.root)
        shaoekd = getSharedPreferences("NAME_AV_RUSH", MODE_PRIVATE)
        uxzhycg()

    }

    private fun uxzhycg() = with(mvkcijuhds){
       val name = shaoekd.getString("NAME_AV_RUSH","Antony")
        val totnc = intent.getIntExtra("total",0)
        val kms = lisgyds[Random.nextInt(9)]
        val count = kms + totnc
        tvFly.text = "Your Fly : $kms km"
        tvName.text = "Congratulation,$name!"
        tvFnlWon.text = "Your won $count avia points"

        button5.setOnClickListener {
            startActivity(Intent(this@Fwwishuadu,Hquierodijc::class.java))
        }
    }
}