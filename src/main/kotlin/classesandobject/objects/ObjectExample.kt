package com.shaikhabdulgani.classesandobject.objects

open class AccessObjectVar(open var x: Int = 10)

class ObjectExample(var name: String = "obj") {
    object ObjectExtendingClass : AccessObjectVar() {
        override var x = 10

        fun setMyName(name: Int) {
            x = name
        }

        override fun toString(): String {
            return "$x(name=$x)"
        }
    }

    object SecondObjectClass {
        var x = 10
    }

    var objectExpression = object {
        var x = 10
    }
}

fun main(): Unit {
    val obj1 = ObjectExample("obj1")
    val obj2 = ObjectExample("obj2")

    println(obj1.objectExpression)
    println(obj2.objectExpression)
    ObjectExample.ObjectExtendingClass.x = 119
    println(ObjectExample.ObjectExtendingClass)
    println(ObjectExample.SecondObjectClass)
    println(ObjectExample.SecondObjectClass)
}