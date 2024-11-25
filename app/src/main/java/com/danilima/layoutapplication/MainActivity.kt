package com.danilima.layoutapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
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

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.num_people,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        binding.spinnerNumberOfPeople.adapter = adapter

        var numberOfPeopleSelected = 0
        binding.spinnerNumberOfPeople.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                    numberOfPeopleSelected = position
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        binding.btnCalculate.setOnClickListener {
            val totalTableTemp = binding.tieTotal.text

            if (totalTableTemp?.isEmpty() == true) {
            } else {
                val totalTable: Float = totalTableTemp.toString().toFloat()
                val people: Int = numberOfPeopleSelected

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
            binding.tieTotal.setText("")
            binding.rbOption1.isChecked = false
            binding.rbOption2.isChecked = false
            binding.rbOption3.isChecked = false
        }
    }
}