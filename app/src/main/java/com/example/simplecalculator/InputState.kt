package com.example.simplecalculator

abstract class InputState(val expressionStringParser: ExpressionStringParser) {

    //abstract fun getAnswer()
    abstract fun isRefersState(calculatorData: String): Pair<InputState, String>
}