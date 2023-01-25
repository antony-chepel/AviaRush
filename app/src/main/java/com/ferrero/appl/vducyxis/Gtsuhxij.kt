package com.ferrero.appl.vducyxis


import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.facebook.applinks.AppLinkData
import com.ferrero.appl.Joposijxiz
import com.ferrero.appl.kcxuhd.Fyusijxzuh
import com.ferrero.appl.kcxuhd.Euwuisijx
import kotlinx.coroutines.launch

class Gtsuhxij : ViewModel() {
    val rseasyasyg : MutableLiveData<Fyusijxzuh> = MutableLiveData()
val jocxicjxjx : MutableLiveData<Wisxhuc> = MutableLiveData()



        fun icjixvhuhduhvshu(){
            viewModelScope.launch {
                jocxicjxjx.value = Euwuisijx.vicjbhudfhu()

            }
    }



    fun vifijjif(){
        viewModelScope.launch {
            rseasyasyg.value = Euwuisijx.sidasjdjiads()

        }
    }



    fun bnbivvbuh(dijf: Context) {
        val locpxicxhu = dijf.getSharedPreferences(Joposijxiz.wiooowsodk,Application.MODE_PRIVATE)
        AppLinkData.fetchDeferredAppLinkData(
            dijf
        ) { sososodsdjia: AppLinkData? ->
            sososodsdjia?.let {
                val params = sososodsdjia.targetUri?.host.toString()
                locpxicxhu.edit().putString(Joposijxiz.wiooowsodk,params).apply()
            }
            if (sososodsdjia == null) {
            }
        }
    }



}