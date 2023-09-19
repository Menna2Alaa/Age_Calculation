package com.example.age_calculation

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.age_calculation.databinding.FragmentBirthBinding
import java.time.LocalDate
import java.time.Period


class BirthFragment : Fragment() {
    private lateinit var binding: FragmentBirthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentBirthBinding.inflate(inflater,container,false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.datePicker.setOnDateChangedListener { _, year, month, day ->
            val birthDate = LocalDate.of(year, month + 1, day)
            calculateAge(birthDate)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun calculateAge(birthDate: LocalDate) {
        val currentDate = LocalDate.now()
        val age: Period = Period.between(birthDate, currentDate)
        val years = age.years
        val months = age.months
        val days = age.days

        val ageString = "Age: $years years, $months months, $days days"
        binding.resText.text=ageString
    }

}
