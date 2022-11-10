package com.habby.archeroa.spin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.TextView
import com.habby.archeroa.R
import kotlin.math.floor


class WheelActivity : AppCompatActivity() ,Animation.AnimationListener{
    private var count = 0
    private var flag = false

    private var powerButton: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wheel)
        powerButton = findViewById(R.id.powerButton)
        powerButton!!.setOnTouchListener(PowerTouchListener())
        intSpinner()
    }


    val prizes = intArrayOf(100, 300, 500, 1000, 600, 400, 200, 900, 3000, 400, 1000, 1200, 3000, 1500)
    private var mSpinDuration: Long = 0
    private var mSpinRevolution = 0f
    var pointerImageView: ImageView? = null
    var infoText: TextView? = null
    var prizeText = "N/A"

    private fun intSpinner() {
        pointerImageView = findViewById(R.id.imageWheel)
        infoText = findViewById(R.id.infoText)
    }

    fun startSpinner() {
        mSpinRevolution = 3600f
        mSpinDuration = 5000

        if (count >= 10) {
            mSpinDuration = 2000
            mSpinRevolution = (3600 * 2).toFloat()
        }
        if (count >= 20) {
            mSpinDuration = 20000
            mSpinRevolution = (3600 * 3).toFloat()

        }


        val end = floor(Math.random() * 3600).toInt()
        val numOfPrizes = prizes.size
        val shift = 0
        val prizeIndex = (shift + end) % numOfPrizes

        prizeText = "You won : ${prizes[prizeIndex]}"
        prizeText.uppercase()

        val rotateAnim = RotateAnimation(
            0f, mSpinRevolution + end,
            Animation.RELATIVE_TO_SELF,
            0.5f, Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotateAnim.interpolator = DecelerateInterpolator()
        rotateAnim.repeatCount = 0
        rotateAnim.duration = mSpinDuration
        rotateAnim.setAnimationListener(this)
        rotateAnim.fillAfter = true
        pointerImageView!!.startAnimation(rotateAnim)

    }

    private inner class PowerTouchListener: View.OnTouchListener {
        @SuppressLint("ClickableViewAccessibility")
        override fun onTouch(p0: View?, motionEvent: MotionEvent?): Boolean {

            when(motionEvent!!.action){
                MotionEvent.ACTION_DOWN ->{
                    flag = true
                    count = 0
                    Thread{
                        while (flag){
                            count++
                            if (count == 100){
                                try {
                                    Thread.sleep(1000)
                                }catch (e: InterruptedException) {
                                    e.printStackTrace()
                                }
                                count = 0
                            }
                            try {
                                Thread.sleep(5)
                            }
                            catch (e: InterruptedException){
                                e.printStackTrace()
                            }
                        }
                    }.start()
                    return true
                }
                MotionEvent.ACTION_UP ->{
                    flag = false
                    startSpinner()
                    return false
                }
            }
            return false
        }

    }

    override fun onAnimationStart(p0: Animation?) {
        infoText!!.text = "Spinning started..."

    }

    override fun onAnimationEnd(p0: Animation?) {
        infoText!!.text = prizeText
    }

    override fun onAnimationRepeat(p0: Animation?) {
    }
}

