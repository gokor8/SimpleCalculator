package com.example.simplecalculator.InputStates

import androidx.core.text.isDigitsOnly
import com.example.simplecalculator.AnotherOperation
import com.example.simplecalculator.ExpressionStringParser
import com.example.simplecalculator.InputState

class NumberInputState(mutableExpressionList: MutableList<String>, statesList: List<InputState>) :
    InputState(mutableExpressionList, statesList), AnotherOperation {

    constructor(mutableExpressionList: MutableList<String>) : this(mutableExpressionList, listOf())

    override fun isTriggered(char: Char): Boolean = char.isDigit()

    override fun getDefaultReturnState(): InputState = NumberInputState(mutableExpressionList, statesList)

    override fun addNewOperation(operation: String) {
        val lastStringExpression = mutableExpressionList.last()

        if(lastStringExpression.isEmpty() || lastStringExpression.lastOrNull() == '.'
            || lastStringExpression.last().isDigit())
            mutableExpressionList[mutableExpressionList.size-1] += operation
        else
            mutableExpressionList.add(operation)
    }
}