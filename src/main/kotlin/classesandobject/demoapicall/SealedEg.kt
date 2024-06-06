package com.shaikhabdulgani.classesandobject.demoapicall

import com.google.gson.Gson
import java.net.URL

/**
 * Fetches a Todo object from an API endpoint given its ID.
 * @param id The ID of the Todo object to fetch.
 * @return An ApiResult object representing the outcome of the fetch operation.
 *         If successful, it contains the fetched Todo object wrapped in an ApiResult.Success.
 *         If unsuccessful, it contains an error message wrapped in an ApiResult.Error.
 */
fun fetchTodoFromApi(id: Int): ApiResult {
    val url = "https://jsonplaceholder.typicode.com/todos/$id"
    return try {
        val result = URL(url).readText()
        val todo = Gson().fromJson(result, Todo::class.java)
        ApiResult.Success(todo)
    } catch (e: Exception) {
        ApiResult.Error("Cannot fetch todo for id: $id")
    }
}

fun main() {
    when (val res = fetchTodoFromApi(10)) {
        is ApiResult.Error -> {
            println(res.message)
        }
        is ApiResult.Success -> {
            println(res.todo)
            if (res.todo.id.isValid()) {
                println("Id is not valid")
            } else {
                println("Id is not valid")
            }
        }
    }
}