package com.knoldus.testDivideandFibonacci

import com.knoldus.implementation.ImplClass

import org.scalatest.flatspec.AnyFlatSpec


class DivideAndFibonacciImplTest extends AnyFlatSpec {

  val forValidatingDivideOpr =new ImplClass()

  // Test cases to validate divide method

  "A number 20" should "return 4 when divided by 5" in{

    assert(forValidatingDivideOpr.divide(20,5)==4)
  }

  it should "throw ArithmeticException when divided by 0" in{

    assertThrows[ArithmeticException] {
      forValidatingDivideOpr.divide(20,0)
    }
  }
  // Unit Test Cases for Fibonacci.
  "Fibonacci series " should "return [0,1,1] " in {
    val result = forValidatingDivideOpr.fibonacci( 0, 1,  3)
    assert(result sameElements Array[Int](xs = 0, 1, 1))
  }

  "Fibonacci series " should "return [4,5,9,14,23] " in {
    val result = forValidatingDivideOpr.fibonacci(4, 5, 5)
    assert(result sameElements Array[Int](xs = 4,5,9,14,23))

  }

  "Fibonacci series " should "not return [0,1,1,2,2] " in {
    val result = forValidatingDivideOpr.fibonacci( 0,  1,  5)
    assert(result != Array[Int](xs = 0,1,1,2,2))
  }
}