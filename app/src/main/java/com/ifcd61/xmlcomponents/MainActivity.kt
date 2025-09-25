package com.ifcd61.xmlcomponents

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.ifcd61.xmlcomponents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<MaterialButton>(R.id.btnSkip).setOnClickListener {
            findViewById<MaterialCardView>(R.id.cvAd).visibility = View.GONE
        }

        binding.btnBuy.setOnClickListener {
            Toast.makeText(this,"Historial", Toast.LENGTH_SHORT).show()
        }

        binding.btnSkip.setOnClickListener {
            binding.cvAd.visibility = View.GONE
        }

        val url: String = "https://upload.wikimedia.org/wikipedia/commons/6/66/Android_robot.png"
        Glide.with(this)
            .load(url)
            .into(binding.imgUrl)

    }
}