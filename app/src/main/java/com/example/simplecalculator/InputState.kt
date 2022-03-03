package com.example.simplecalculator

import com.example.simplecalculator.InputStates.NumberInputState

abstract class InputState(val mutableExpressionList: MutableList<String>, val statesList: List<InputState>) {

    abstract fun isTriggered(char: Char): Boolean
    abstract fun getDefaultReturnState(): InputState

    open fun getState(calculatorData: String): Pair<InputState, String>{
        for (state in statesList) {
            if (state.isTriggered(calculatorData[0])) {
                if (state is AnotherOperation)
                    state.addNewOperation(calculatorData)

                return Pair(state, calculatorData)
            }
        }

        return Pair(getDefaultReturnState(), "")
    }
}