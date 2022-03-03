package com.example.simplecalculator.InputStates

import androidx.core.text.isDigitsOnly
import com.example.simplecalculator.AnotherOperation
import com.example.simplecalculator.ExpressionStringParser
import com.example.simplecalculator.InputState

class NumberInputState(mutableExpressionList: MutableList<String>, statesList: List<InputState>) :
    InputState(mutableExpressionList, statesList), AnotherOperation {

    /*statesList =
        listOf<InputState>(DotInputState(expressionStringParser), OperatorInputState(expressionStringParser))*/

    override fun isTriggered(char: Char): Boolean = char.isDigit()

    override fun getDefaultReturnState(): InputState = NumberInputState(mutableExpressionList, statesList)

    override fun addNewOperation(operation: String) {
        val lastStringExpression = mutableExpressionList.last()

        if(lastStringExpression.last() == '.' || lastStringExpression.last().isDigit())
            mutableExpressionList[mutableExpressionList.size-1] += operation
        else
            mutableExpressionList.add(operation)
    }
}