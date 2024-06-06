package com.shaikhabdulgani.classesandobject.demoapicall

@JvmInline
value class Id(private val id: Int) : Validator {
    override fun isValid(): Boolean {
        return id <= 10
    }
}