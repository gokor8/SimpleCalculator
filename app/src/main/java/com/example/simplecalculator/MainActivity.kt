package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.simplecalculator.InputStates.DotInputState
import com.example.simplecalculator.InputStates.NumberInputState
import com.example.simplecalculator.InputStates.OperatorInputState

var tvOutput: TextView? = null
var tvOutputHistory: TextView? = null

var expressionStringParser: ExpressionStringParser? = null
var currentState: InputState? = null

class MainActivity : AppCompatActivity() {

    init {
        expressionStringParser = ExpressionStringParser()
        val notNullExpressionList = expressionStringParser?.mutableExpressionList?: mutableListOf("")
        val stateList = listOf(NumberInputState(notNullExpressionList),
            DotInputState(notNullExpressionList), OperatorInputState(notNullExpressionList))

        currentState = NumberInputState(notNullExpressionList, stateList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvOutput = findViewById(R.id.tvOutput)
        tvOutputHistory = findViewById(R.id.tvOutputHistory)

        val buttonAC = findViewById<Button>(R.id.btnClear)
        buttonAC.setOnClickListener {
            tvOutput?.text = ""
            expressionStringParser?.mutableExpressionList?.clear()
            expressionStringParser?.mutableExpressionList?.add("")
        }

        tvOutput?.text = ""
        tvOutputHistory?.text = ""
    }

    fun onClick(view: View){
        val button = view as Button
        val stateResponse = currentState?.getState(button.text.toString())
        currentState = stateResponse?.first

        tvOutput?.text = tvOutput?.text.toString() + stateResponse?.second
        tvOutputHistory?.text = expressionStringParser?.getAnswer()
    }
}