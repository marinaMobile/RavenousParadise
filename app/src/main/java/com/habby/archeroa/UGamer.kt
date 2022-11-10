package com.habby.archeroa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.habby.archeroa.databinding.ActivityUgamerBinding
import com.habby.archeroa.spin.MachineActivity
import com.habby.archeroa.spin.WheelActivity

class UGamer : AppCompatActivity() {
    lateinit var bindUGamer: ActivityUgamerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindUGamer = ActivityUgamerBinding.inflate(layoutInflater)
        setContentView(bindUGamer.root)

        bindUGamer.machineGame.setOnClickListener{
            startActivity(Intent(this, MachineActivity::class.java))
        }

        bindUGamer.wheelGame.setOnClickListener{
            startActivity(Intent(this, WheelActivity::class.java))
        }
    }
}