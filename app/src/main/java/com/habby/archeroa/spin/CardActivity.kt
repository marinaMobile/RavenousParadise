package com.habby.archeroa.spin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.habby.archeroa.R
import com.habby.archeroa.databinding.ActivityCardBinding

class CardActivity : AppCompatActivity() {
    lateinit var bindCardAct: ActivityCardBinding
    private var imgOne: Int = 0
    private var imgTwo: Int = 0
    private var imgThree: Int = 0
    private var imgFour: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindCardAct = ActivityCardBinding.inflate(layoutInflater)
        setContentView(bindCardAct.root)

        var hearts = bindCardAct.hearts
        var clubs = bindCardAct.clubs
        var diamonds = bindCardAct.diamonds
        var spades = bindCardAct.spades







    }
}