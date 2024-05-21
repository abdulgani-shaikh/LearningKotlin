package com.shaikhabdulgani.controlflow

enum class Bit {
    ZERO, ONE
}

fun main() {
    basicWhenExpression(1)
    whenWithoutElse(Bit.ZERO)
    commonBehaviourCase(1)
    notOnlyConstants(10, 10)
    noArgumentWhen(13, 10)
}

fun noArgumentWhen(x: Int, y: Int) {
    fun isOdd(i: Int): Boolean = i % 2 == 1
    fun isEven(i: Int): Boolean = i % 2 == 0
    //when can also be used as a replacement for an if-else chain.
    //If no argument is supplied, the branch conditions
    //are simply boolean expressions, and a branch is
    //executed when its condition is true:
    when {
        isOdd(x) -> print("x is odd")
        isEven(y) -> print("y is even")
        else -> print("x+y is odd")
    }
}

fun notOnlyConstants(s: Long, x: Int) {
    //You can use arbitrary expressions
    //(not only constants) as branch conditions
    when (x) {
        s.toInt() -> print("s encodes x")
        else -> print("s does not encode x")
    }

    //You can also check a value for
    //being in or !in a range or a collection
    when (x) {
        in 1..10 -> print("x is in the range")
        !in 10..20 -> print("x is outside the range")
        else -> print("none of the above")
    }
}

fun commonBehaviourCase(x: Int) {
    //To define a common behavior for multiple cases,
    //combine their conditions in a single line with a comma
    when (x) {
        0, 1 -> print("x == 0 or x == 1")
        else -> print("not 0 or 1")
    }
}

fun whenWithoutElse(x: Bit) {
    //no need to write else because all the possible conditions are covered
    val numericValue = when (x) {
        Bit.ZERO -> 0
        Bit.ONE -> 1
    }
}

fun basicWhenExpression(x: Int) {
    //when expression is similar to switch case in java.
    //But in when we don't need to explicitly write break
    when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> {
            print("x is neither 1 nor 2")
        }
    }
}

fun equal(x: Int, y: Int): Boolean {
    return when ((x == y) != true) {
        true -> false
        false -> true
    }
}