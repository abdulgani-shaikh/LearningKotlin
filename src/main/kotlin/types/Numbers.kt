package com.shaikhabdulgani.types

fun main() {
    initializeIntegers()
    initializeFloats()
    literalConstants()
    underScoreReadability()
    numbersInJVM()
    implicitWidening()
    operationsOnNumbers()
    bitwiseOpertions()
}

fun bitwiseOpertions() {
    val x = (1 shl 2) and 0x000FF000
    println(x)
    /*
    More bitwise operators in kotlin
    shl(bits) – signed shift left
    shr(bits) – signed shift right
    ushr(bits) – unsigned shift right
    and(bits) – bitwise AND
    or(bits) – bitwise OR
    xor(bits) – bitwise XOR
    inv() – bitwise inversion
     */
}

fun implicitWidening() {
    fun printDouble(d: Double) {
        print(d)
    }

    val i = 1
    val d = 1.0
    val f = 1.0f

    printDouble(d)
//    printDouble(i) // Error: Type mismatch
//    printDouble(f) // Error: Type mismatch
}

fun initializeFloats() {
    val pi = 3.14 // Double
    // val one: Double = 1 // Error: type mismatch
    val oneDouble = 1.0 // Double
    val e = 2.7182818284 // Double

    //If a value contains more than 6-7 decimal digits, it will be rounded
    val eFloat = 2.7182818284f // Float, actual value is 2.7182817
}

fun operationsOnNumbers() {
    println(1 + 2)
    println(2_500_000_000L - 1L)
    println(3.14 * 2.71)
    println(10.0 / 3)
}

fun numbersInJVM() {
    // non-nullable is stored as primitive in JVM
    val a = 100

    // non-nullable is stored as Boxed Java Class in JVM
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    val b: Int = 10000
    val boxedB: Int? = b
    val anotherBoxedB: Int? = b

    println(boxedA === anotherBoxedA) // true
    println(boxedB === anotherBoxedB) // false
}

fun underScoreReadability() {
    var binaryFormatInt = 0b1111_1110_1111_1011
    println(binaryFormatInt)
}

fun literalConstants() {
    var hexFormatInt: Int = 0xfe
    var binaryFormatInt: Int = 0b1111_1110
    var decimalFormatInt: Int = 254

    println("hex: $hexFormatInt")
    println("binary: $binaryFormatInt")
    println("decimal: $decimalFormatInt")

    var areAllEqual = hexFormatInt == binaryFormatInt && binaryFormatInt == decimalFormatInt

    println("Are they all equal: ${if (areAllEqual) "yes" else "no"}")
}

fun initializeIntegers() {
    val one = 1 // Int
    val threeBillion = 3000000000 // Long
    val oneLong = 1L // Long
    val oneByte: Byte = 1 //Byte
    val oneShort: Short = 123 //Short
}
