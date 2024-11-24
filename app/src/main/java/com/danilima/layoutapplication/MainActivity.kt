package com.danilima.layoutapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.danilima.layoutapplication.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        var percentage: Int = 0

//        val btnClean = findViewById<Button>(R.id.btn_clean)
//        val btnCalculate = findViewById<Button>(R.id.btn_calculate)
//        val edtTotal = findViewById<TextInputEditText>(R.id.tie_total)
//        val edtPeople = findViewById<TextInputEditText>(R.id.tie_people)

//        btnClean.setOnClickListener {}
        binding.btnClean.setOnClickListener {  }
        binding.rbOption1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 10
            }
        }
        binding.rbOption2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 15
            }
        }
        binding.rbOption3.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 20
            }
        }
        binding.btnCalculate.setOnClickListener {
            val totalTableTemp = binding.tieTotal.text
            val peopleTemp = binding.tiePeople.text

            if (totalTableTemp?.isEmpty() == true || peopleTemp?.isEmpty() == true) {
                Snackbar.make(binding.tiePeople, "Preencha todos os campos", Snackbar.LENGTH_LONG).show()
            } else {
                val totalTable: Float = totalTableTemp.toString().toFloat()
                val people: Int = peopleTemp.toString().toInt()

                val totalTemp = totalTable / people
                val tips = totalTemp * percentage / 100
                val totalWithTips = totalTemp + tips
                println(totalTemp)
                println(tips)
                println(totalWithTips)
                binding.tvResult.text = "Total with tips: $totalWithTips"

            }
        }
        binding.btnClean.setOnClickListener {
            binding.tvResult.text = ""
            binding.tiePeople.setText("")
            binding.tieTotal.setText("")
            binding.rbOption1.isChecked = false
            binding.rbOption2.isChecked = false
            binding.rbOption3.isChecked = false
        }
    }
}