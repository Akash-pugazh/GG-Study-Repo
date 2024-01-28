package com.example.gg_study_repo

fun main() {
    val numbers = setOf(1, 2, 3, 4)

    println(numbers.map { it * 2})
    val nummberMap = mapOf(1 to "Hello", 2 to "Hi")
    println(nummberMap.mapKeys { it })


}

fun initializations() {
    val names = listOf("Akash", "Pugazh")
    val numbers = mutableListOf(1, 2, 3)

    val uniqueNames = setOf(1, 2, 3, 1, 1)
    val mutableNumbers = mutableSetOf(1, 2, 3, 4)

    val namesId = mapOf(1 to "Aakash", 2 to "Pugazh")
    val result = mutableMapOf(1 to "Akash", 2 to "Pugazh")
}
