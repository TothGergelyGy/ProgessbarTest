package com.example.progressbar2

import android.R
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.progressbar2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var progr = 0
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateProgressBar()
        var myIntArray = intArrayOf(0)
        var myIntArray2 = Array<Int>(3, {it * 1})
        val myColorStateList = ColorStateList(
            arrayOf
            (
                intArrayOf(R.attr.state_active),
                intArrayOf(R.attr.state_enabled),
            ),
            intArrayOf
            (
                Color.RED,  //1
                Color.GREEN,  //2
            )
        )

        binding.progressBar.isEnabled=true
        binding.progressBar.progressDrawable.setTint(0xff25deff.toInt())
        binding.progressBar.progressBackgroundTintList= myColorStateList
        binding.buttonIncr.setOnClickListener {
            if (progr <= 90) {
                progr += 10
                updateProgressBar()
            }
        }
    }


    private fun updateProgressBar() {
        binding.progressBar.progress = progr
        binding.textProgress.text = "$progr%"
    }
}