package com.example.gg_study_repo

fun main() {
    val list = listOf<Int>(1, 2, 3, 4)
    val list2 = list.map { it * 2 }
    println(list.joinToString(" ") { "[$it]" })

    list.map(transform = { el -> el * 10 })
    list.forEachIndexed { index, element -> println("index : $index element : $element") }
    list.forEachIndexed { index, _ -> println("index : $index") }
    println(list2)

    list.indices.forEach { println(it) }

    fun foo(a: Int = 1, b: Int) {}
    foo(b = 3)

    fun <T> foo(vararg arg: T): ArrayList<T> {
        val tempArray = ArrayList<T>()
        for (element in arg) {
            tempArray.add(element)
        }
        return tempArray
    }

    val testIntArray = intArrayOf(12, 32, 1, 2, 3, 4)
    val testVarargs = foo(1, 2, 3, 4)
    println(testVarargs)
    println(foo(*testIntArray.toTypedArray()))


    val testList = listOf(1, 2, 3, 4, 5)
    testList.fold(0) { acc: Int, i: Int ->
        val res = acc + i
        res
    }
    //
    fun addTwoNumbers(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    fun printResultOfSum(first: Int, second: Int, addFn: twoIntInputAndReturnsInt): Int {

        return addFn(first, second)
    }

//    printResultOfSum(1, 2, ::addTwoNumbers)

    println(printResultOfSum(1, 2) { a, b -> a + b })

    println(printResultOfSum(1, 2) { a, b -> a + b })


//    val testtt = mutableMapOf<String, Int>()

//    val l = List(size = 10) { it }
//    println('a' + 10)
//    for (char in ('a'..'z')) println(char)


    val isEven = { el: Int -> el % 2 == 0 }
    println(List(size = 10) { it + 1 }.filter(isEven))

    println(List(10){it + 1}.any{ it > 15 })

    val res = List(10){it + 1}.sum()
    val listTest = (1..10).toList()

    listTest.all(isEven)

    val (one, two, three) = listOf(1, 2, 3)



}


typealias twoIntInputAndReturnsInt = (Int, Int) -> Int



