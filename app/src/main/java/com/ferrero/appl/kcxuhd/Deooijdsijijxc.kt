package com.ferrero.appl.kcxuhd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ferrero.appl.databinding.ActivityDeooijdsijijxcBinding
import com.ferrero.appl.moicxuhd.Hquierodijc

class Deooijdsijijxc : AppCompatActivity() {
    private lateinit var xiuzjcizjxc : ActivityDeooijdsijijxcBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        xiuzjcizjxc = ActivityDeooijdsijijxcBinding.inflate(layoutInflater)
        setContentView(xiuzjcizjxc.root)
        kixjizjxc()
    }


    private fun kixjizjxc() = with(xiuzjcizjxc){
      imageView2.setOnClickListener {
          startActivity(Intent(this@Deooijdsijijxc,Hquierodijc::class.java))
      }
    }
}