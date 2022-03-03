package com.example.simplecalculator

import com.example.simplecalculator.InputStates.NumberInputState
import com.example.simplecalculator.InputStates.StartState

abstract class InputState(
    val mutableExpressionList: MutableList<String>,
    protected var statesList: List<InputState>
) {

    abstract fun isTriggered(char: Char): Boolean
    abstract fun getDefaultReturnState(): InputState

    open fun getState(calculatorData: String): Pair<InputState, String> {
        /*if(mutableExpressionList.first().isEmpty())
            return Pair(StartState(mutableExpressionList, statesList), "")*/

        for (state in statesList) {
            if (state.isTriggered(calculatorData[0])) {
                if (state is AnotherOperation)
                    state.addNewOperation(calculatorData)

                state.statesList = statesList

                return Pair(state, calculatorData)
            }
        }

        return Pair(getDefaultReturnState(), "")
    }
}