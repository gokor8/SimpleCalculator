package com.example.simplecalculator.InputStates

import com.example.simplecalculator.AnotherOperation
import com.example.simplecalculator.ExpressionStringParser
import com.example.simplecalculator.InputState

open class OperatorInputState(mutableExpressionList: MutableList<String>, statesList: List<InputState>, )
    : InputState(mutableExpressionList, statesList),
    AnotherOperation {

    constructor(mutableExpressionList: MutableList<String>) : this(mutableExpressionList, listOf())

    open val operationsList = listOf('+', '-', '/', '*')

    override fun isTriggered(char: Char): Boolean =
        operationsList.contains(char) && (mutableExpressionList.last().isNotEmpty()
                && mutableExpressionList.last().last().isDigit())
                || (mutableExpressionList.last().isEmpty() && char == '-')

    override fun getDefaultReturnState(): InputState = OperatorInputState(mutableExpressionList, statesList)

    override fun addNewOperation(operation: String) {
        mutableExpressionList.add(operation)
    }
}