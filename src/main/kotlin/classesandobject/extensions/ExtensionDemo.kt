package com.shaikhabdulgani.classesandobject.extensions

private class Class1 {
    companion object {
        const val CONSTANT_VALUE = "Constant Value"
    }
}

fun String?.isNullOrEmpty(): Boolean {
    return this == null || this.isEmpty()
}

val String.size: Int
    get() = this.length

fun String.capitalizeFirstLetter(): String {
    return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
}

private fun Class1?.extensionFunction() {
    println("Extension function called on Class1 instance: ${this?.toString()}")
}

private fun Class1.Companion.companionExtFun() {
    println("Extension function called on Class1.Companion")
}

fun main() {
    val nullableString: String? = null
    println(nullableString.isNullOrEmpty())

    val nonNullString = "hello"
    println(nonNullString.size)

    val stringWithLowerCase = "hello world"
    println(stringWithLowerCase.capitalizeFirstLetter()) 

    val class1Instance: Class1? = null
    class1Instance.extensionFunction()

    Class1.companionExtFun()
}
