package com.shaikhabdulgani.classesandobject.demoapicall

sealed class ApiResult {
    data class Success(val todo: Todo) : ApiResult()
    data class Error(val message: String) : ApiResult()
}