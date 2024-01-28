package com.example.gg_study_repo

fun main() {
    println(properties(12.5, 20.5))
    val nemo: Fish = Fish()
    nemo.makeSound()
    communicate(message = { println("re") }, time = { 1000L })

    val cow = Mammal()
    cow cross nemo
//    nemo is breed parameter here infix will be working in this manner
//    cow.cross(nemo)

    println(calculate(1, 2))
    val randList = listOf(1, 3123,  43, -32, 43)
    val negNumber = randList.find(fun(num) = num < 0)
    println(negNumber)

//    try {
//        println(factorial(4312389718937))
//    } catch (e: StackOverflowError){
//        println("Stack overflowed")
//    }

    val coord1 = Coordinates(1, 1, 1)
    val coord2 = Coordinates(1, 1, 1)
    val coord3 = coord1 + coord2
    println(coord3)

    Invoker()
//    Opertor overloading on invoke in a singleton creatable object can be done here
//    NonInvoker()
//    Generates Error
}

fun properties(length: Double, width: Double): Pair<Double, Double> {
    fun area(): Double = length * width
    fun perimeter(): Double = length + width
    return Pair(area(), perimeter())
}

fun maxSum(a: Int?, b: Int?): Int? {
    fun isValid(): Boolean = a != null && b != null
    return if (isValid()) Int.MAX_VALUE else -1
}

abstract class Animal(private val name: String){
    abstract val limbs: Int
    abstract val sound: String?
    abstract val gestation: Double
    open fun makeSound(){
        fun customSound(): String {
            return if (sound.isNullOrBlank())
                "The $name does not make sound"
            else
                "The $name makes $sound"
        }
        println(customSound())
    }
    open fun move(direction: String){
        println("""
            My $name is heading towards the $direction
        """.trimIndent())
    }

    infix fun cross(breed: Animal) {
        fun checkBreeds(): Double {
            return if(breed.name.lowercase() == name.lowercase()) breed.gestation else breed.gestation + gestation
        }
        println("""
            The ${breed.name} and $name will give offspring after ${checkBreeds()} months!
        """.trimIndent())
    }

}

class Fish(): Animal("Fish"){
    override val limbs: Int
        get() = 0
    override val sound: String?
        get() = null
    override val gestation: Double
        get() = 3.0
}

class Mammal: Animal("Mammal"){
    override val limbs: Int
        get() = 4
    override val sound: String?
        get() = "Moo"
    override val gestation: Double
        get() = 9.0
}

// Hof
// Inner Functions
// Lazy Evaluation

inline fun communicate(message: () -> Unit, noinline time: () -> Long) {
    println("Communication Started")
    message()
    println("The time taken is ${time()}")
}

val calculate = fun (a: Int, b: Int): Int {
    return a + b
}

tailrec fun factorial(num: Long, total: Long = 1): Long {
    val temp = num * total
    return if(num <= 1){
        temp
    } else factorial(num - 1, temp)
}


data class Coordinates(
    val x: Int,
    val y: Int,
    val z: Int
) {
//    Operator overloading
    operator fun plus(coordinate: Coordinates): Coordinates {
        val (x1, x2, x3) = coordinate
        return Coordinates(
            x1 + x,
            x2 + y,
            x3 + z
        )
    }
}

object Invoker {
    operator fun invoke() {
        println("This function is invokable")
    }
}

object NonInvoker {

}
