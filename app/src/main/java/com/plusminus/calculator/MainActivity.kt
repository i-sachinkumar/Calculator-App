package com.plusminus.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.plusminus.calculator.databinding.ActivityMainBinding
import java.lang.NumberFormatException
import kotlin.math.sin


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var operand1: Double = 0.0
    private var operand2: Double = 0.0



    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //variables to hold the operands
        binding.buttonZero.setOnClickListener {
            binding.manualEntry.append(binding.buttonZero.text.toString())
        }

        binding.buttonOne.setOnClickListener {
            binding.manualEntry.append(binding.buttonOne.text.toString())
        }

        binding.buttonTwo.setOnClickListener {
            binding.manualEntry.append(binding.buttonTwo.text.toString())
        }

        binding.buttonThree.setOnClickListener {
            binding.manualEntry.append(binding.buttonThree.text.toString())

        }

        binding.buttonFour.setOnClickListener {
            binding.manualEntry.append(binding.buttonFour.text.toString())

        }

        binding.buttonFive.setOnClickListener {
            binding.manualEntry.append(binding.buttonFive.text.toString())

        }

        binding.buttonSix.setOnClickListener {
            binding.manualEntry.append(binding.buttonSix.text.toString())

        }

        binding.buttonSeven.setOnClickListener {
            binding.manualEntry.append(binding.buttonSeven.text.toString())

        }

        binding.buttonEight.setOnClickListener {
            binding.manualEntry.append(binding.buttonEight.text.toString())

        }

        binding.buttonNine.setOnClickListener {
            binding.manualEntry.append(binding.buttonNine.text.toString())

        }

        binding.buttonDot.setOnClickListener {
            binding.manualEntry.append(binding.buttonDot.text.toString())

        }

        binding.buttonSin?.setOnClickListener {
            if (binding.finalanswer.text.isEmpty() && binding.manualEntry.text.isNotEmpty()) {
                performOperation()
                binding.operator.text = "sin"
            } else if (binding.finalanswer.text.isNotEmpty() && binding.manualEntry.text.isNotEmpty()) {
                performOperation()
                binding.operator.text = "sin"
            } else {
                binding.operator.text = binding.buttonSin?.text.toString()
            }

        }

        binding.buttonCos?.setOnClickListener {
            binding.manualEntry.append(binding.buttonCos?.text.toString())

        }


        //Operator Buttons - Below!!
        binding.buttonPlus.setOnClickListener {
            if (binding.finalanswer.text.isEmpty() && binding.manualEntry.text.isNotEmpty()) {
                binding.finalanswer.append(binding.manualEntry.text)
                binding.manualEntry.text.clear()
                binding.operator.text = binding.buttonPlus.text.toString()
            } else if (binding.finalanswer.text.isNotEmpty() && binding.manualEntry.text.isNotEmpty()) {
                performOperation()
                binding.operator.text = "+"
            } else {
                binding.operator.text = binding.buttonPlus.text.toString()
            }
        }

        binding.buttonMinus.setOnClickListener {

            if (binding.finalanswer.text.isEmpty() && binding.manualEntry.text.isNotEmpty()) {
                binding.finalanswer.append(binding.manualEntry.text)
                binding.manualEntry.text.clear()
                binding.operator.text = binding.buttonMinus.text.toString()
            } else if (binding.finalanswer.text.isNotEmpty() && binding.manualEntry.text.isNotEmpty()) {
                performOperation()
                binding.operator.text = "-"
            } else {
                binding.operator.text = binding.buttonMinus.text.toString()
            }

        }

        binding.buttonMultiple.setOnClickListener {

            if (binding.finalanswer.text.isEmpty() && binding.manualEntry.text.isNotEmpty()) {
                binding.finalanswer.append(binding.manualEntry.text)
                binding.manualEntry.text.clear()
                binding.operator.text = binding.buttonMultiple.text.toString()
            } else if (binding.finalanswer.text.isNotEmpty() && binding.manualEntry.text.isNotEmpty()) {
                performOperation()
                binding.operator.text = "*"
            } else {
                binding.operator.text = binding.buttonMultiple.text.toString()
            }
        }

        binding.buttonDivide.setOnClickListener {

            if (binding.finalanswer.text.isEmpty() && binding.manualEntry.text.isNotEmpty()) {
                binding.finalanswer.append(binding.manualEntry.text)
                binding.manualEntry.text.clear()
                binding.operator.text = binding.buttonDivide.text.toString()
            } else if (binding.finalanswer.text.isNotEmpty() && binding.manualEntry.text.isNotEmpty()) {
                performOperation()
                binding.operator.text = "/"
            } else {
                binding.operator.text = binding.buttonDivide.text.toString()
            }
        }

        binding.buttonEquals.setOnClickListener {

            if (binding.finalanswer.text.isEmpty() && binding.manualEntry.text.isNotEmpty()) {
                binding.finalanswer.append(binding.manualEntry.text)
                binding.manualEntry.text.clear()
                binding.operator.text = binding.buttonEquals.text.toString()
            } else if (binding.finalanswer.text.isNotEmpty() && binding.manualEntry.text.isNotEmpty()) {
                performOperation()
                binding.operator.text = "="
            } else {
                binding.operator.text = binding.buttonEquals.text.toString()
            }

        }

        binding.clearAll.setOnClickListener {
            clearAll()
        }


    }

    private fun clearAll() {
        binding.finalanswer.text.clear()
        binding.manualEntry.text.clear()
        binding.operator.text = ""
    }

    private fun performOperation() {
        try {
            operand2 = binding.manualEntry.text.toString().toDoubleOrNull()!!
            operand1 = binding.finalanswer.text.toString().toDoubleOrNull()!!
        } catch (e: NumberFormatException) {
            clearAll()
        }
        if(binding.manualEntry.text.toString() != "." && binding.finalanswer.text.toString() != "." ) {

            when (binding.operator.text.toString()) {
                "+" -> operand1 += operand2
                "-" -> operand1 -= operand2
                "*" -> operand1 *= operand2
                "/" -> if (operand2 != 0.0) {
                    operand1 /= operand2
                } else operand1 = 0.0

                "=" -> operand1 = operand2
                "sin" -> operand1 = sin(operand2)
            }
            binding.finalanswer.text.clear()
            binding.finalanswer.append(operand1.toString())
            binding.manualEntry.text.clear()

        }
    }

    override
    fun onSaveInstanceState(outState: Bundle) {

        super.onSaveInstanceState(outState)
    }
}







