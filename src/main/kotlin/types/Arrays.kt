package com.shaikhabdulgani.types

fun main() {
    initializeArray()
    initializeArrayUsingArrayOf()
    nestedArray()
    reassignArray()
    comparisonOfTwoArray()
    changeAfterAssignment()
    arrayOfNullableElement()
    emptyArrayEg()
    varargsEg("Abdul Gani", "Hemil", "Gaurav", "Amey")
    arraysToCollection("Abdul Gani", "Hemil", "Gaurav", "Amey")

    var primitiveArray = intArrayOf(1, 2, 3, 4);
    var objectArray = Array(4) { it + 1 }
    println(primitiveArray.contentEquals(objectArray.toIntArray()))
}

fun arraysToCollection(vararg array: String) {

    // Converts to a Set
    println(array.toSet())

    // Converts to a List
    println(array.toList())
}

fun varargsEg(vararg names: String) {
    for (name in names) {
        print("$name, ")
    }
    println()
}

fun initializeArrayUsingArrayOf() {
    val simpleArray = arrayOf(1, 2, 3)
    println(simpleArray.joinToString())
}

fun nestedArray() {
    val twoDArray = Array(2) { i: Int -> Array(2) { it } }
    println(twoDArray.contentDeepToString())
}

fun initializeArray() {
    val array: Array<Int> = Array(10) { i: Int -> i };
    println(array.joinToString())
}

fun emptyArrayEg() {
    var exampleArray = emptyArray<String>()
    println(exampleArray.size)
}

fun arrayOfNullableElement() {
    val nullArray: Array<Int?> = arrayOfNulls(3)
    println(nullArray.joinToString())
    nullArray[0] = 10
    println(nullArray.joinToString())
}

fun changeAfterAssignment() {
    var riversArray = arrayOf("Nile", "Amazon", "Yangtze")
    var riversArray3 = riversArray

    println("Before:")
    println(riversArray.joinToString())
    println(riversArray3.joinToString())

    riversArray3.set(0, "Ganga")

    println("After:")
    println(riversArray.joinToString())
    println(riversArray3.joinToString())
}

fun comparisonOfTwoArray() {
    var riversArray = arrayOf("Nile", "Amazon", "Yangtze")
    var riversArray2 = arrayOf("Nile", "Amazon", "Yangtze")
    var riversArray3 = riversArray2
    println(riversArray.contentEquals(riversArray2))
    println(riversArray == riversArray2)
    println(riversArray === riversArray2)
    println(riversArray3 == riversArray2)
    println(riversArray3 === riversArray2)
}


fun reassignArray() {
    var riversArray = arrayOf("Nile", "Amazon", "Yangtze")
    riversArray += "Mississippi"
    println(riversArray.joinToString())
}