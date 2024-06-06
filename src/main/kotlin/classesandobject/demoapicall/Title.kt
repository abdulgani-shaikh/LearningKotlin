package com.shaikhabdulgani.classesandobject.demoapicall

@JvmInline
value class Title(private val title: String) : Validator {
    override fun isValid(): Boolean {
        return title.length <= 10
    }
}