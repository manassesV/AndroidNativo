package com.example.logonrmlocal.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splatch.*

class SplatchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splatch)


        load()

    }

    private fun load() {
        var animation = AnimationUtils.loadAnimation(this, R.anim.splach)

        animation.reset()
        ivLogo.startAnimation(animation)


        Handler().postDelayed({
            startActivity(Intent(this, FormActivity::class.java))
            finish()
        }, 3500L)
    }
}
