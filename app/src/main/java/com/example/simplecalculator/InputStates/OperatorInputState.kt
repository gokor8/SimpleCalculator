package com.example.simplecalculator.InputStates

import com.example.simplecalculator.ExpressionStringParser
import com.example.simplecalculator.InputState

open class OperatorInputState(expressionStringParser: ExpressionStringParser) :
    InputState(expressionStringParser) {

    override fun isRefersState(calculatorData: String): Pair<InputState, String> {

        if (expressionStringParser.secondValue != "") {
            expressionStringParser.firstValue = expressionStringParser.getAnswer()
            expressionStringParser.secondValue = ""
        }

        if (calculatorData[0].isDigit()) {
            val numberInput = NumberInputState(expressionStringParser)
            numberInput.isRefersState(calculatorData)

            return Pair<InputState, String>(
                numberInput,
                calculatorData
            )
        }
        else
            expressionStringParser.mathSymbol = calculatorData[0]

        return Pair<InputState, String>(OperatorInputState(expressionStringParser), "")
    }
}