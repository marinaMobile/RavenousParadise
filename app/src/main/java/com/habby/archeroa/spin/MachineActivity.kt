package com.habby.archeroa.spin

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.habby.archeroa.R
import com.habby.archeroa.databinding.ActivityMachineBinding
import java.util.*

class MachineActivity : AppCompatActivity() {
    lateinit var bindMachineGame: ActivityMachineBinding

    var r = Random()
    var img1: Int = 0
    var img2: Int = 0
    var img3: Int = 0
    var starterScore = 10000;
    lateinit var imvOneAct: ImageView
    lateinit var imvTwoAct: ImageView
    lateinit var imvThrAct: ImageView
    lateinit var scoreTxt: TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindMachineGame = ActivityMachineBinding.inflate(layoutInflater)
        setContentView(bindMachineGame.root)

        imvOneAct = bindMachineGame.imvOne
        imvTwoAct = bindMachineGame.imvTwo
        imvThrAct = bindMachineGame.imvThree
        scoreTxt = bindMachineGame.scoreText
        scoreTxt.text = starterScore.toString()

        bindMachineGame.rollBtn.setOnClickListener{
           var minus1k: Int = starterScore-1000
            starterScore = minus1k
            scoreTxt.text = starterScore.toString()


        imvOneAct.setBackgroundResource(R.drawable.anime)
        val imageOneAnim: AnimationDrawable = imvOneAct.background as AnimationDrawable
        imageOneAnim.start()

        imvTwoAct.setBackgroundResource(R.drawable.anime)
        val imageTwoAnim: AnimationDrawable = imvTwoAct.background as AnimationDrawable
        imageTwoAnim.start()

        imvThrAct.setBackgroundResource(R.drawable.anime)
        val imageThrAnim: AnimationDrawable = imvThrAct.background as AnimationDrawable
        imageThrAnim.start()

        Handler(Looper.getMainLooper()).postDelayed({
            imageOneAnim.stop()
            imageTwoAnim.stop()
            imageThrAnim.stop()

            setImages()

            getScore()

        }, 300)


    }
    }

    private fun setImages() {
        img1 = r.nextInt(5)+1
        img2 = r.nextInt(5)+1
        img3 = r.nextInt(5)+1

        when (img1) {
            1 ->
                imvOneAct.setBackgroundResource(R.drawable.one)
            2 ->
                imvOneAct.setBackgroundResource(R.drawable.two)
            3 ->
                imvOneAct.setBackgroundResource(R.drawable.three)
            4 ->
                imvOneAct.setBackgroundResource(R.drawable.four)
            5 ->
                imvOneAct.setBackgroundResource(R.drawable.five)
        }
        when (img2) {
            1 ->
                imvTwoAct.setBackgroundResource(R.drawable.one)
            2 ->
                imvTwoAct.setBackgroundResource(R.drawable.two)
            3 ->
                imvTwoAct.setBackgroundResource(R.drawable.three)
            4 ->
                imvTwoAct.setBackgroundResource(R.drawable.four)
            5 ->
                imvTwoAct.setBackgroundResource(R.drawable.five)
        }
        when (img3) {
            1 ->
                imvThrAct.setBackgroundResource(R.drawable.one)
            2 ->
                imvThrAct.setBackgroundResource(R.drawable.two)
            3 ->
                imvThrAct.setBackgroundResource(R.drawable.three)
            4 ->
                imvThrAct.setBackgroundResource(R.drawable.four)
            5 ->
                imvThrAct.setBackgroundResource(R.drawable.five)

        }

    }

    private fun getScore() {

        if (img1 == img2 && img2 == img3) {
            Toast.makeText(this, "Jackpot!", Toast.LENGTH_SHORT).show()
        }
        if(img1 == img2 || img2 == img3 || img1 == img3) {
            Toast.makeText(this, "Awesome!", Toast.LENGTH_SHORT).show()
        }


    }
}