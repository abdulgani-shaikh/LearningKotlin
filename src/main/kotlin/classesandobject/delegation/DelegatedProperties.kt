package com.shaikhabdulgani.classesandobject.delegation

import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

var var1: String = "Hello2"
var var2: String = "Hello2"
var var6 = A()

open class A
open class B : A()
class DelegatedProperties(var var2: String = "default", name: String) {
    var var3: String by this::var2
    var var4: String by ::var1
    var var5: A by ::var6

    fun printAllVar() {
        println("This is top-level var1: $var1")
        println("This is class-level var4: ${this.var4}")
        println("This is class-level var2: ${this.var2}")
        println("This is class-level var3: ${this.var3}")
    }
}

class Resource

class Owner {
    var valResource: Resource by ResourceDelegate()
}

class ResourceDelegate {
    operator fun getValue(thisRef: Owner, property: KProperty<*>): Resource {
        println("In getter")
        return Resource()
    }

    operator fun setValue(thisRef: Owner, property: KProperty<*>, var2: Resource) {
        println("in setter")
    }
}

fun main() {
    var delegatedProperties = DelegatedProperties("abdulgani", "")
    delegatedProperties.printAllVar()
    delegatedProperties.var2 = "abdulgani2"
    delegatedProperties.printAllVar()

    delegatedProperties.var3 = "abdulgani2"
    delegatedProperties.printAllVar()

    println(var1 == delegatedProperties.var4)
    println(var1 === delegatedProperties.var4)

    var name: String by Delegates.customObserver("default") { old, new ->
        println("old val is $old new value is $new")
    }

    name = "1"
    name = "2"
    name = "3"
    name = "4"
    Owner().valResource
    Owner().valResource = Resource()
}

fun <T> Delegates.customObserver(
    defaultVal: T,
    onChange: (T, T) -> Unit = { _, _ -> },
) = object : ReadWriteProperty<Any?, T> {
    var oldVal: T = defaultVal
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return oldVal
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        onChange(oldVal, value)
        oldVal = value
    }
}
