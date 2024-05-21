package com.shaikhabdulgani.controlflow

fun main() {
    simpleIfBlock("Abdul Gani")
    simpleIfBlock("John")

    elseIfLadder("Abdul Gani")
    elseIfLadder("John")
    elseIfLadder("Jane")

    val a = 20;
    val b = 10;
    println("Max of $a and $b is ${maxOfInt(a, b)}")
    println("Max of $a and $b is ${printAndGetMax(a, b)}")
}

fun printAndGetMax(a: Int, b: Int): Int {
    //The last expression is the value of a block:
    return if (a <= b) {
        print("Choose b")
        b
    } else {
        print("Choose a")
        a
    }

}

fun maxOfInt(a: Int, b: Int): Int {
    //In Kotlin, if is an expression: it returns a value.
    //Therefore, there is no ternary operator (condition ? then : else)
    return if (a <= b) b else a
}

fun elseIfLadder(name: String) {
    if (name == "Abdul Gani") {
        println("Welcome Abdul Gani!")
    } else if (name == "John") {
        println("Welcome John Doe!")
    } else {
        println("You can not enter the house $name")
    }
}

fun simpleIfBlock(name: String) {
    if (name == "Abdul Gani") {
        println("Welcome Abdul Gani!")
    } else {
        println("You can not enter the house $name")
    }
}
