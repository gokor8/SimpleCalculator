package com.example.simplecalculator.InputStates

import com.example.simplecalculator.InputState

class StartState(mutableExpressionList: MutableList<String>, statesList: List<InputState>) :
    InputState(mutableExpressionList, statesList) {

    override fun getState(calculatorData: String): Pair<InputState, String> {
        if(calculatorData[0].isDigit()) {
            val numberState = NumberInputState(mutableExpressionList, statesList)
            numberState.addNewOperation(calculatorData)
            return Pair(numberState, calculatorData)
        }

        return Pair(getDefaultReturnState(), "")
    }

    override fun isTriggered(char: Char): Boolean = false

    override fun getDefaultReturnState(): InputState = StartState(mutableExpressionList, statesList)
}