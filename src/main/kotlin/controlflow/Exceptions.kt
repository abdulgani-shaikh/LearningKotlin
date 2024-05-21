package com.shaikhabdulgani.controlflow

/*
    IMPORTANT NOTE
    Kotlin doesn't have concept of checked exception.
    Every exception is unchecked.
 */

//Throws annotation has no use in kotlin itself
//but used to make interoperability with java better
@Throws(Exception::class)
fun main(){
    try {
        throwException()
    } catch (e: Exception) {
        println(e.toString())
    } finally {
        println("In finally")
    }
    tryAsExpression("12")
    elvisOperatorWithThrow(Person(null))
}

fun tryAsExpression(input: String) {
    val a: Int? = try {
        input.toInt()
    } catch (e: NumberFormatException) {
        null
    } finally {
        println("a will not be accessible here in finally")
    }
}

fun throwException() {
    throw Exception("Hii, I am Exception")
}

class Person(val name: String?)

fun elvisOperatorWithThrow(person: Person) {
    val s: String = person.name ?: throw Exception("Name cannot be null")
    println(s)
}

/*
    IMPORTANT NOTE
    You may also encounter this type when dealing with type inference.
    The nullable variant of this type, Nothing?, has exactly one possible value,
    which is null. If you use null to initialize a value of an
    inferred type and there's no other information that can be used to determine
    a more specific type, the compiler will infer the Nothing? type:

    val x = null           // 'x' has type `Nothing?`
    val l = listOf(null)   // 'l' has type `List<Nothing?>
 */