package com.codegalaxy.pagingimpldec16.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codegalaxy.pagingimpldec16.R
import com.codegalaxy.pagingimpldec16.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ProductFragment())
                .commit()
        }
    }
}
