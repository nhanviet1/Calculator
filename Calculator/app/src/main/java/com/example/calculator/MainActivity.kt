package com.example.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var stringHolder1 = ""
    private var stringHolder2 = ""
    private var checker = ""
    private var resultX: Float = 0F
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
        binding.sol.text = resultX.toString()
    }

    private fun setup() {
        binding.zero.setOnClickListener {
            addToString("0")
        }
        binding.one.setOnClickListener {
            addToString("1")
        }
        binding.two.setOnClickListener {
            addToString("2")
        }
        binding.three.setOnClickListener {
            addToString("3")
        }
        binding.four.setOnClickListener {
            addToString("4")
        }
        binding.five.setOnClickListener {
            addToString("5")
        }
        binding.six.setOnClickListener {
            addToString("6")
        }
        binding.seven.setOnClickListener {
            addToString("7")
        }
        binding.eight.setOnClickListener {
            addToString("8")
        }
        binding.nine.setOnClickListener {
            addToString("9")
        }

        binding.dot.setOnClickListener {
            if (!stringHolder1.contains(".") && checker == ""){
                addToString(".")
            }
            if (!stringHolder2.contains(".") && checker != ""){
                addToString(".")
            }
        }

        binding.equal.setOnClickListener {
            result()
        }

        binding.clear.setOnClickListener {
            clear()
        }

        binding.plus.setOnClickListener {
            plus()
        }

        binding.minus.setOnClickListener {
            minus()
        }

        binding.multiply.setOnClickListener {
            multiply()
        }

        binding.divide.setOnClickListener {
            divide()
        }
        binding.converter.setOnClickListener {
            converter()
        }
    }

    private fun clear() {
        stringHolder1 = ""
        stringHolder2 = ""
        resultX = 0F
        binding.problem.text = ""
        binding.sol.text = "0"
        checker = ""
    }

    private fun result() {
        when (checker) {
            "plus" -> plus()
            "minus" -> minus()
            "multiply" -> multiply()
            "divide" -> divide()
        }
        binding.sol.text = resultX.toString()
    }

    private fun addToString(value: String) {
        if (checker == "") {
            stringHolder1 += value
            binding.problem.text = stringHolder1
        } else {
            stringHolder2 += value
            binding.problem.text = stringHolder2
        }
    }

    private fun plus() {
        if (checker != "plus" && checker != "") {
            result()
            checker = "plus"
        } else {
            if (checker == "" && stringHolder1 != "") {
                checker = "plus"
            } else if (checker == "plus" && stringHolder2 != "") {
                resultX = stringHolder1.toFloat() + stringHolder2.toFloat()
                stringHolder1 = resultX.toString()
                stringHolder2 = ""
                result()
            }
        }
    }

    private fun minus() {
        if (checker != "minus" && checker != "") {
            result()
            checker = "minus"
        } else {
            if (checker == "" && stringHolder1 != "") {
                checker = "minus"
            } else if (checker == "minus" && stringHolder2 != "") {
                resultX = stringHolder1.toFloat() - stringHolder2.toFloat()
                stringHolder1 = resultX.toString()
                stringHolder2 = ""
                result()
            }
        }
    }

    private fun multiply() {
        if (checker != "multiply" && checker != "") {
            result()
            checker = "multiply"
        } else {
            if (checker == "" && stringHolder1 != "") {
                checker = "multiply"
            } else if (checker == "multiply" && stringHolder2 != "") {
                resultX = stringHolder1.toFloat() * stringHolder2.toFloat()
                stringHolder1 = resultX.toString()
                stringHolder2 = ""
                result()
            }
        }
    }

    private fun divide() {
        if (checker != "divide" && checker != "") {
            result()
            checker = "divide"
        } else {
            if (checker == "" && stringHolder1 != "") {
                checker = "divide"
            } else if (checker == "divide" && stringHolder2 != "") {
                resultX = stringHolder1.toFloat() / stringHolder2.toFloat()
                stringHolder1 = resultX.toString()
                stringHolder2 = ""
                result()
            }
        }
    }

    private fun converter() {
        if (checker == "" && stringHolder1 != "") {
            val holderX = stringHolder1.toFloat() * -1
            stringHolder1 = holderX.toString()
            binding.problem.text = stringHolder1
        } else if (checker != "" && stringHolder2 != "") {
            val holderX = stringHolder2.toFloat() * -1
            stringHolder2 = holderX.toString()
            binding.problem.text = stringHolder2
        }
    }
}