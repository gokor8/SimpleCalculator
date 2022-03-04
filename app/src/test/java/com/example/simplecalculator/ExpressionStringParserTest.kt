package com.example.simplecalculator

import org.junit.Assert
import org.junit.Test

class ExpressionStringParserTest {

    val expressionStringParser = ExpressionStringParser()

    @Test
    fun expressionList_isStringInt(){
        expressionStringParser.mutableExpressionList.addAll(listOf("5","-","2"))

        Assert.assertEquals("3", expressionStringParser.getAnswer())
    }

    @Test
    fun expressionList_isStringFloat(){
        expressionStringParser.mutableExpressionList.addAll(listOf("5.1","-","2"))

        Assert.assertEquals("3.1", expressionStringParser.getAnswer())
    }
}