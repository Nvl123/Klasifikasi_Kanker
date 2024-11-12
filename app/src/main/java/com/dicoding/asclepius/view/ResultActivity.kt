package com.dicoding.asclepius.view

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dicoding.asclepius.databinding.ActivityResultBinding


class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageUri = Uri.parse(intent.getStringExtra(EXTRA_IMAGE_URI))
        imageUri?.let {
            Log.d("Image URI", "showimage: $it")
            binding.resultImage.setImageURI(it)
        }
        val resulText = intent.getStringExtra(EXTRA_RESULT)
        resulText?.let {
            binding.resultText.text = it
        }

        val inferenceTime = intent.getStringExtra(EXTRA_INFERNCE_TIME)
        inferenceTime?.let {
            binding.inferenceTime.text =it
        }

    }

    companion object {
        const val EXTRA_IMAGE_URI = "extra_image_uri"
        const val EXTRA_RESULT = "extra_result"
        const val EXTRA_INFERNCE_TIME = "ectra_inference_time"
    }


}