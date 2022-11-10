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
    private lateinit var bindMachineGame: ActivityMachineBinding

    private var r = Random()
    private var img1: Int = 0
    private var img2: Int = 0
    private var img3: Int = 0
    private var starterScore = 10000
    private lateinit var imvOneAct: ImageView
    private lateinit var imvTwoAct: ImageView
    private lateinit var imvThrAct: ImageView
    private lateinit var scoreTxt: TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindMachineGame = ActivityMachineBinding.inflate(layoutInflater)
        setContentView(bindMachineGame.root)

        bindMachineGame.imvOne.also { imvOneAct = it }
        bindMachineGame.imvTwo.also { imvTwoAct = it }
        bindMachineGame.imvThree.also { imvThrAct = it }
        bindMachineGame.scoreText.also { scoreTxt = it }
        scoreTxt.text = starterScore.toString()

        bindMachineGame.rollBtn.setOnClickListener{
           val minus1k: Int = starterScore-1000
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

        }, 1000)
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
            val plus10k: Int = scoreTxt.text.toString().toInt()+10000
            Toast.makeText(this, "JACKPOT! +10000", Toast.LENGTH_SHORT).show()
            scoreTxt.text=plus10k.toString()
        }
        if(img1 == img2 || img2 == img3 || img1 == img3) {
            val plus2k: Int = scoreTxt.text.toString().toInt()+2000
            Toast.makeText(this, "+2000", Toast.LENGTH_SHORT).show()

            scoreTxt.text=plus2k.toString()
        }

    }
}