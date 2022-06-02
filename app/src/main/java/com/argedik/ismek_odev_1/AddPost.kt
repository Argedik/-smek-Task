package com.argedik.ismek_odev_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.argedik.ismek_odev_1.databinding.ActivityAddPostBinding

class AddPost : AppCompatActivity() {
    private lateinit var binding:ActivityAddPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddPostBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}