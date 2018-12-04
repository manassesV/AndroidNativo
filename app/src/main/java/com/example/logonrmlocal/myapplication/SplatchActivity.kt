package com.example.logonrmlocal.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splatch.*

class SplatchActivity : AppCompatActivity() {

    private  lateinit var preference: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splatch)

        preference = getSharedPreferences("user_preferences", Context.MODE_PRIVATE);
        val isFirsOpen = preference.getBoolean("open_first", true)


        if (isFirsOpen){
            markAppAlReadOpen()
            load()
        }else{
            showMain()
        }


    }

    private fun markAppAlReadOpen() {
        val editor = preference.edit().apply {
            putBoolean("open_first", false)
            commit()
        }
    }

    private fun load() {
        var animation = AnimationUtils.loadAnimation(this, R.anim.splach)

        animation.reset()
        ivLogo.startAnimation(animation)


        Handler().postDelayed({
            showMain()
        }, 3500L)
    }

    private fun showMain() {
        startActivity(Intent(this, FormActivity::class.java))
        finish()
    }
}
