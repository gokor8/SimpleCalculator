package com.example.simplecalculator

import android.util.Log

class ExpressionStringParser() {

    val mutableExpressionList = mutableListOf("")

    fun getAnswer(): String {

        var stringData = ""
        for (i in mutableExpressionList)
            stringData += " [$i]"

        Log.d("operationListData", stringData)
        return ""
        /*if(!isFieldsFill())
            return ""

        val firstNumber = firstValue.toInt()
        val secondNumber = secondValue.toInt()

        val intAnswer = when (mathSymbol) {
            '+' -> firstNumber + secondNumber
            '-' -> firstNumber - secondNumber
            '*' -> firstNumber * secondNumber
            '/' -> firstNumber / secondNumber
            else -> firstNumber + secondNumber
        }

        return intAnswer.toString()*/
    }

//    private fun isFieldsFill() =
//        firstValue != "" && mathSymbol != null && secondValue != ""

    /*var firstValue = 0
    var mathSymbol: Char? = null
    var secondValue = 0

    for(char in expression) {
        if(char.isDigit())
            if(mathSymbol == null)
                firstValue += char.digitToInt()
            else
                secondValue += char.digitToInt()
        else
            mathSymbol = char
    }*/
}