package com.shaikhabdulgani.types

fun main() {
    isOperator("Abdul Gani")
    isOperator(10)
    smartCast("Abdul Gani")
    safeCastOperator(null)
    unsafeCastOperator(null)
}

fun safeCastOperator(y: Any?) {
    val x: String? = y as? String
    println("Casted safely. No errors")
}

fun unsafeCastOperator(y: Any?) {
    try {
        val x: String = y as String
    } catch (e: Exception) {
        println("Unsafe casting 1")
    }
    try {
        val x: String? = y as String?
    } catch (e: Exception) {
        println("Unsafe casting 2")
    }
}

fun isOperator(obj: Any) {
    //Use the is operator or its negated form !is
    // to perform a runtime check that identifies
    // whether an object conforms to a given type
    if (obj is String) {
        println(obj.length)
    }

    if (obj !is String) { // Same as !(obj is String)
        println("Not a String")
    } else {
        println(obj.length)
    }
}

fun smartCast(x: Any) {
    if (x is String) {
        println(x.length) // x is automatically cast to String
    }
}
