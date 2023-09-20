package com.example.age_calculation

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.age_calculation.databinding.FragmentDateBinding
import java.time.LocalDate
import java.time.Period


class DateFragment : Fragment() {
    private lateinit var binding: FragmentDateBinding
    private lateinit var textView: TextView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDateBinding.inflate(inflater,container,false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.datePicker.setOnDateChangedListener { _, year1, month1, day1 ->
            val startDate = LocalDate.of(year1, month1 + 1, day1)
        }
        binding.datePicker2.setOnDateChangedListener { _, year2, month2, day2 ->
            val endDate = LocalDate.of(year2, month2 + 1, day2)
        }
        binding.btnRes2.setOnClickListener {
            val startDate = LocalDate.of(
                binding.datePicker.year,
                binding.datePicker.month + 1,
                binding.datePicker.dayOfMonth
            )
            val endDate = LocalDate.of(
                binding.datePicker2.year,
                binding.datePicker2.month + 1,
                binding.datePicker2.dayOfMonth
            )
            calculateDateDifference(startDate,endDate)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun calculateDateDifference(startDate: LocalDate, endDate: LocalDate) {
        val period: Period = Period.between(startDate, endDate)
        val years = period.years
        val months = period.months
        val days = period.days
        val difference = "Difference: $years years, $months months, $days days"

        binding.resTxt.text=difference

    }
}
