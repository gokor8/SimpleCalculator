package com.example.simplecalculator.InputStates

import com.example.simplecalculator.ExpressionStringParser
import com.example.simplecalculator.InputState

class NumberInputState(expressionStringParser: ExpressionStringParser) :
    InputState(expressionStringParser) {

    override fun isRefersState(calculatorData: String): Pair<InputState, String> {
        if(!calculatorData[0].isDigit()) {
            val operatorState = OperatorInputState(expressionStringParser)
            operatorState.isRefersState(calculatorData)

            return Pair<InputState, String>(
                operatorState,
                calculatorData
            )
        }

        if(expressionStringParser.firstValue == "")
            expressionStringParser.firstValue += calculatorData
        else
            expressionStringParser.secondValue += calculatorData

        return Pair<InputState, String>(NumberInputState(expressionStringParser), calculatorData)
    }
}