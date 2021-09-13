package com.knoldus.implementation

import com.knoldus.question2.Divide_Fibonacci

class ImplClass extends Divide_Fibonacci{

  override def divide(num1: Int, num2: Int): Int = {

  val result = num1/num2;
      result;
    }


  override def fibonacci(firstTerm: Int, secondTerm: Int, totalNoTerms: Int): Array[Int] = {
    val fibonacciSeries: Array[Int] = new Array[Int](totalNoTerms)
    var a = firstTerm
    var b = secondTerm
    fibonacciSeries(0) = firstTerm
    fibonacciSeries(1) = secondTerm
    for (i <- 2 until totalNoTerms) {
      val next_term = a + b
      fibonacciSeries(i) = next_term
      a = b
      b = next_term
    }
    fibonacciSeries
  }
}
