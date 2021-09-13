package com.knoldus.question2

object Main {
  def main(args:Array[String]): Unit ={
    val functionsImpl = new Divide_Fibonacci {
      override def divide(num: Int, denominator: Int): Int = ???

      override def fibonacci(firstValue: Int, secondValue: Int, totalNoValue: Int): Array[Int] = ???
    }
    val result = functionsImpl.fibonacci(0,1,3)

    functionsImpl.divide(12,0)
    println(println(result.mkString(" "))
    )

  }
}
