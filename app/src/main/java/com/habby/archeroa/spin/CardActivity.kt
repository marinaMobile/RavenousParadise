package com.habby.archeroa.spin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import com.habby.archeroa.R
import com.habby.archeroa.databinding.ActivityCardBinding
import java.util.*

class CardActivity : AppCompatActivity() {
    lateinit var bindCardAct: ActivityCardBinding
    private var imgOne: Int = 0
    private lateinit var imvOneCard: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindCardAct = ActivityCardBinding.inflate(layoutInflater)
        setContentView(bindCardAct.root)

        var hearts = bindCardAct.hearts
        var clubs = bindCardAct.clubs
        var diamonds = bindCardAct.diamonds
        var spades = bindCardAct.spades

        imvOneCard = findViewById(R.id.mainCard)



        hearts.setOnClickListener{
            if (imgOne == 1) {
                Toast.makeText(this, "You win", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "You lose", Toast.LENGTH_SHORT).show()
            }
            setImages()

        }

        clubs.setOnClickListener{
            if (imgOne == 2) {
                Toast.makeText(this, "You win", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "You lose", Toast.LENGTH_SHORT).show()
            }
            setImages()

        }

        diamonds.setOnClickListener{
            if (imgOne == 3) {
                Toast.makeText(this, "You win", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "You lose", Toast.LENGTH_SHORT).show()
            }
            setImages()

        }
        spades.setOnClickListener{

            if (imgOne == 4) {
                Toast.makeText(this, "You win", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "You lose", Toast.LENGTH_SHORT).show()
            }
            setImages()
        }

    }

    private fun setImages() {
        imgOne = (1 until 5).random()

        when (imgOne) {
            1 ->
                imvOneCard.setBackgroundResource(R.drawable.hearts)
            2 ->
                imvOneCard.setBackgroundResource(R.drawable.clubs)
            3 ->
                imvOneCard.setBackgroundResource(R.drawable.diamonds)
            4 ->
                imvOneCard.setBackgroundResource(R.drawable.spades)

        }
    }
}
