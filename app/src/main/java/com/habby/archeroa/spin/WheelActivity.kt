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
    private var sdcwrgbytkh = 0
    private var sxqewv4tgjh6uk = false

    private var frgyhjikddd: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wheel)
        frgyhjikddd = findViewById(R.id.powerButton)
        frgyhjikddd!!.setOnTouchListener(PowerTouchListener())
        intSpinner()
    }


    val dcrtgth7 = intArrayOf(100, 300, 500, 1000, 600, 400, 200, 900, 3000, 400, 1000, 1200, 3000, 1500)
    private var frtgyh: Long = 0
    private var xcvghjio = 0f
    var fvrhyuj8iol: ImageView? = null
    var zsxwrgujk: TextView? = null
    var xwdcerfh = "N/A"

    private fun intSpinner() {
        fvrhyuj8iol = findViewById(R.id.imageWheel)
        zsxwrgujk = findViewById(R.id.infoText)
    }

    fun wdcwrtg() {
        xcvghjio = 3600f
        frtgyh = 5000

        if (sdcwrgbytkh >= 10) {
            frtgyh = 2000
            xcvghjio = (3600 * 2).toFloat()
        }
        if (sdcwrgbytkh >= 20) {
            frtgyh = 20000
            xcvghjio = (3600 * 3).toFloat()

        }


        val end = floor(Math.random() * 3600).toInt()
        val numOfPrizes = dcrtgth7.size
        val shift = 0
        val prizeIndex = (shift + end) % numOfPrizes

        xwdcerfh = "You won : ${dcrtgth7[prizeIndex]}"
        xwdcerfh.uppercase()

        val rgethyuj = RotateAnimation(
            0f, xcvghjio + end,
            Animation.RELATIVE_TO_SELF,
            0.5f, Animation.RELATIVE_TO_SELF, 0.5f
        )
        rgethyuj.interpolator = DecelerateInterpolator()
        rgethyuj.repeatCount = 0
        rgethyuj.duration = frtgyh
        rgethyuj.setAnimationListener(this)
        rgethyuj.fillAfter = true
        fvrhyuj8iol!!.startAnimation(rgethyuj)

    }

    private inner class PowerTouchListener: View.OnTouchListener {
        @SuppressLint("ClickableViewAccessibility")
        override fun onTouch(p0: View?, motionEvent: MotionEvent?): Boolean {

            when(motionEvent!!.action){
                MotionEvent.ACTION_DOWN ->{
                    sxqewv4tgjh6uk = true
                    sdcwrgbytkh = 0
                    Thread{
                        while (sxqewv4tgjh6uk){
                            sdcwrgbytkh++
                            if (sdcwrgbytkh == 100){
                                try {
                                    Thread.sleep(1000)
                                }catch (e: InterruptedException) {
                                    e.printStackTrace()
                                }
                                sdcwrgbytkh = 0
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
                    sxqewv4tgjh6uk = false
                    wdcwrtg()
                    return false
                }
            }
            return false
        }

    }

    override fun onAnimationStart(p0: Animation?) {
        zsxwrgujk!!.text = "Spinning started..."

    }

    override fun onAnimationEnd(p0: Animation?) {
        zsxwrgujk!!.text = xwdcerfh
    }

    override fun onAnimationRepeat(p0: Animation?) {
    }
}

