package com.example.numberofwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.numberofwords.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var wordsNumber = 0
        var currentText = ""
        var savedText = ""

        binding.editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                currentText = binding.editText.text.toString().trim()
                wordsNumber = currentText.split(" ").size
                if (currentText.isNullOrEmpty()) binding.statsView.text = "0"
                else binding.statsView.text = "$wordsNumber"
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
        binding.saveButton.setOnClickListener {
            if (currentText.isNullOrEmpty()) binding.unsavedChangesView.text = "Edittext is empty"
            else savedText = binding.editText.text.toString()
        }

        binding.clearButton.setOnClickListener {
            binding.editText.setText("")
        }

        binding.loadButton.setOnClickListener {
            if (currentText != savedText) binding.unsavedChangesView.text = "Unsaved changes"
            else binding.unsavedChangesView.text = "All changes saved"
        }
    }


}