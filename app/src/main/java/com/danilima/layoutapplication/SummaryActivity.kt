package com.danilima.layoutapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.danilima.layoutapplication.databinding.ActivityMainBinding
import com.danilima.layoutapplication.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val totalTable = intent.getFloatExtra("totalTable", 0.0f)
        val people = intent.getIntExtra("people", 0)
        val percentage = intent.getIntExtra("percentage", 0)
        val totalAmount = intent.getFloatExtra("totalAmount", 0.0f)

        binding.tvPercentage.text = percentage.toString() + "%"
        binding.tvTotalAmount.text = totalAmount.toString()
        binding.tvTotalTable.text = totalTable.toString()
        binding.tvNumPeople.text = people.toString()

        binding.btnRefresh.setOnClickListener {
            finish()
        }
    }
}