package com.example.simplecalculator

import android.util.Log

open class ExpressionStringParser(open val mutableExpressionList: MutableList<String> = mutableListOf("")) {

    open val baseExpressionList: List<Char> = listOf('+','-')
    open val mainExpressionList = listOf('*','/')

    open fun getAnswer(): String {

        if(mutableExpressionList.last().isEmpty()
            || !mutableExpressionList.last().last().isDigit())
            return ""

        val baseExpressionList = findMainExtensions()

        var answer = 0f
        var operator: Char? = null
        for (expression in baseExpressionList) {

            when {
                operator != null -> {
                    answer = getExpressionResult(operator, answer, expression.toFloat())
                    operator = null
                }
                this.baseExpressionList.contains(expression[0]) -> operator = expression[0]
                answer == 0f -> answer = expression.toFloat()
            }
        }

        if(answer % 1 == 0f)
            return answer.toInt().toString()

        return answer.toString()
    }

    private fun findMainExtensions(): List<String> {
        val copyExpressionList = mutableListOf("")
        mutableExpressionList.forEach { copyExpressionList.add(it) }

        for ((index, expression) in copyExpressionList.withIndex())
            if(expression.isNotEmpty() && mainExpressionList.contains(expression[0])) {
                copyExpressionList[index + 1] = getExpressionResult(
                    expression[0],
                    copyExpressionList[index - 1].toFloat(),
                    copyExpressionList[index + 1].toFloat()
                ).toString()

                copyExpressionList[index - 1] = ""
                copyExpressionList[index] = ""
            }

        return copyExpressionList.filter { it != "" }
    }

    protected open fun getExpressionResult(mathSymbol: Char, firstNumber: Float, secondNumber: Float)
    : Float =
        when (mathSymbol) {
            '+' -> firstNumber + secondNumber
            '-' -> firstNumber - secondNumber
            '*' -> firstNumber * secondNumber
            '/' -> firstNumber / secondNumber
            else -> firstNumber + secondNumber
        }
}