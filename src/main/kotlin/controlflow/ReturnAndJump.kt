package com.shaikhabdulgani.controlflow

fun main() {
    breakWithLabel(5)
    continueWithLabel(5)
    returnWithoutLabel()
    println()
    explicitLabel()
    implicitLabel()
    println("-------------------------------------------------")
    //stop printing when encountered 3
    run loop@{
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@loop // non-local return from the lambda passed to run
            print(it)
        }
    }
    println(" done with nested loop")
}

fun implicitLabel() {
    //skip printing 3
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return@forEach // local return to the caller of the lambda - the forEach loop
        print(it)
    }
    println(" done with implicit label")
}

//Note that such non-local returns are supported
//only for lambda expressions passed to inline functions.
//To return from a lambda expression, label it and qualify the return:
fun explicitLabel() {
    //skip printing 3
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) return@lit // local return to the caller of the lambda - the forEach loop
        print(it)
    }
    println(" done with explicit label")
}
//return by default returns from
//the nearest enclosing function or anonymous function.
fun returnWithoutLabel() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return // non-local return directly to the caller of returnWithoutLabel()
        print(it)
    }
    println("this point is unreachable")
}

fun continueWithLabel(x: Int) {
    //skip printing i and j when both are 4
    loop@ for (i in 1..x) {
        for (j in 1..x) {
            if (j==4 && i==j) {
                println("---------Skipped printing---------")
                continue@loop
            }
            println("(In Continue function)i is $i and j is $j")
        }
    }
}

fun breakWithLabel(x: Int) {
    //stop printing i and j when both are 4
    loop@ for (i in 1..x) {
        for (j in 1..x) {
            if (j==4 && i==j) {
                println("---------Stopped printing---------")
                break@loop
            }
            println("(In Break function)i is $i and j is $j")
        }
    }
}
