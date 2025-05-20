package com.example.hellofancyworld

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateOvershootInterpolator
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Find the TextView
        val helloText = findViewById<TextView>(R.id.helloText)
        
        // Make it invisible initially
        helloText.alpha = 0f
        
        // Animate the text to appear with a bounce effect
        ObjectAnimator.ofFloat(helloText, View.ALPHA, 0f, 1f).apply {
            duration = 1500
            startDelay = 300
            start()
        }
        
        // Scale animation
        ObjectAnimator.ofFloat(helloText, View.SCALE_X, 0.7f, 1f).apply {
            duration = 1000
            interpolator = AnticipateOvershootInterpolator()
            startDelay = 500
            start()
        }
        
        ObjectAnimator.ofFloat(helloText, View.SCALE_Y, 0.7f, 1f).apply {
            duration = 1000
            interpolator = AnticipateOvershootInterpolator()
            startDelay = 500
            start()
        }
    }
}