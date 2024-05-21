package com.shaikhabdulgani.types

/*
    On the JVM, an object of String type in
    UTF-16 encoding uses approximately 2 bytes per character.
*/

fun main() {
    initializeString()
    loopOverString("Abdul Gani Shaikh")
    accessingIndividualCharacter("Abdul Gani Shaikh")
    immutabilityOfString("Abdul Gani Shaikh")
    stringConcatenation()
    multilinestring()
}

fun multilinestring() {
    val text = """
for (c in "foo")
    print(c)
        """
    print(text)
}

fun stringConcatenation() {
    //concatenating strings with values of other types works,
    //as long as the first element in the expression is a string
    val s = "abc" + 1
    println(s + "def")
}

fun immutabilityOfString(name: String) {

    // Creates and prints a new String object
    println(name.uppercase()) //ABC

    // The original string remains the same
    println(name)
}

fun accessingIndividualCharacter(name: String) {
    for (i in name.indices) {
        print("${name[i]} ")
    }
    println()
}

fun loopOverString(name: String) {
    for (c in name) {
        print(c)
    }
    println()
}

fun initializeString() {
    val str = "Abdul Gani Shaikh"
    println(str)
}
