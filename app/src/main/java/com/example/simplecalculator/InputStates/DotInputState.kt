package com.example.simplecalculator.InputStates

import androidx.core.text.isDigitsOnly
import com.example.simplecalculator.AnotherOperation
import com.example.simplecalculator.ExpressionStringParser
import com.example.simplecalculator.InputState

class DotInputState(expressionList: MutableList<String>, statesList: List<InputState>) : InputState(expressionList,statesList), AnotherOperation {

    override fun isTriggered(char: Char) =
        char == '.' && mutableExpressionList.last().last().isDigit()
                && !mutableExpressionList.last().contains('.')

    override fun getDefaultReturnState(): InputState = DotInputState(mutableExpressionList, statesList)

    override fun addNewOperation(operation: String) {
        mutableExpressionList[mutableExpressionList.size-1] += "."
    }
}