package com.shaikhabdulgani.controlflow

fun main() {
    forLoops()
    whileAndDoWhile()
}

fun whileAndDoWhile() {
    var count = 0
    while (count < 5) {
        println("(In While)Count is: $count")
        count++
    }

    do {
        println("(In Do-While)Count is: $count")
        count++
    } while (count < 5)
}

fun forLoops() {
    //for (item in collection)
    //prints from 1 .. 10 i.e. from 1 to 10
    for (i in 1..10){
        print("$i ")
    }
    println()
    //prints from 6 to 0 taking 2 steps i.e. 6,4,2,0
    for (i in 6 downTo 0 step 2) {
        print("$i ")
    }
    println()

    //If we want to iterate through an array or a
    //list with an index, we can do it this way
    val array = arrayOf(1,2,3,4,5)
    for (i in array.indices) {
        print("${array[i]} ")
    }
    println()

    for ((index, value) in array.withIndex()) {
        println("the element at $index is $value")
    }
}
