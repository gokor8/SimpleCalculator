package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.simplecalculator.InputStates.NumberInputState

var tvOutput: TextView? = null
var tvOutputHistory: TextView? = null

val expressionStringParser = ExpressionStringParser()
var currentState: InputState = NumberInputState(expressionStringParser)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvOutput = findViewById(R.id.tvOutput)
        tvOutputHistory = findViewById(R.id.tvOutputHistory)

        val buttonAC = findViewById<Button>(R.id.btnClear)
        buttonAC.setOnClickListener {
            tvOutput?.text = ""
        }

        tvOutput?.text = ""
        tvOutputHistory?.text = ""
    }

    fun onClick(view: View){
        val button = view as Button
        val stateResponse: Pair<InputState, String> = currentState.isRefersState(button.text.toString())
        currentState = stateResponse.first

        tvOutput?.text = tvOutput?.text.toString() + stateResponse.second
        tvOutputHistory?.text = expressionStringParser.getAnswer()
    }
}