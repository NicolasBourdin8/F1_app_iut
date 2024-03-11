package com.example.formula1app

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.formula1app.fragment.FragmentHome

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentContainer = findViewById<FrameLayout>(R.id.main_fragment_container)

        supportFragmentManager.beginTransaction().replace(fragmentContainer.id, FragmentHome())
            .addToBackStack(null).commit()
    }
}