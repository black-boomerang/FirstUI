package com.example.firstui

import android.animation.Animator
import android.animation.AnimatorInflater
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    private lateinit var card: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle(R.string.app_name)

        card = findViewById(R.id.cardView)
        card.setOnClickListener {
            var animatorSet = AnimatorInflater.loadAnimator(this, R.animator.card_click_animation)
            animatorSet.setTarget(card)
            animatorSet.start()
            val intentThis = this
            animatorSet.addListener(object: Animator.AnimatorListener {
                override fun onAnimationStart(p0: Animator?) {}
                override fun onAnimationCancel(p0: Animator?) {}
                override fun onAnimationRepeat(p0: Animator?) {}
                override fun onAnimationEnd(p0: Animator?) {
                    startActivity(Intent(intentThis, DetailContentActivity::class.java))
                }
            })
        }
    }
}