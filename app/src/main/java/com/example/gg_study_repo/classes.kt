package com.example.gg_study_repo
import java.util.Locale


fun main(args: Array<String>) {
    fun fizzbuzz(number: Int) {
        if (number % 3 == 0 && number % 5 == 0) {
            println("FizzBuzz")
        } else if (number % 3 == 0) {
            println("Fizz")
        } else if (number % 5 == 0) {
            println("Buzz")
        } else {
            println(number)
        }
    }

    fizzbuzz(Integer.parseInt("15"))

    val lambo: Car = Car(name = "Lamborghini", color = "GoldenYellow", model = "v2")

    println(lambo.color)
    println(lambo.model)
    println(lambo.name)
    lambo.move()

    lambo.stop()

    val aakash = User("Aakash", 21)
    val abi: User = User("abi", 18)
    println(aakash.isAllowedToDrink)

    val l1: Lamp = Lamp("l1")
    println(l1.displayLightStatus())

    abi.greet()

//    val akash: Person = Person()
//    akash.name = "Aakash"
//    println("${akash.name}")




//    fun numbersSum(vararg numbers: Int): Int{
//        var res = 0
//        for (num in numbers){
//            res += num
//        }
//        return res
//    }
//


//    numbersSum(1, 2, *tempArray)

    fun varargFun (vararg numbers: Int){
        println(numbers)
    }
    var testArray = IntArray(5)
    for (number in 1..5){
        testArray[number - 1] = number
    }
    println(testArray.contentToString())
//    varargFun(*testArray)


    var numArray: Array<Int> = arrayOf(1, 2, 3)
    numArray.shuffle()
    println(numArray.contentToString())

    var pairArray = arrayOf("Akash" to "It", "Abi" to "Commerce")
    println(pairArray.toMap())

//    primitive Arrays
    var boolArr: BooleanArray = BooleanArray(5)
    println(boolArr.joinToString())

    val x = 12
    val y: String = "12"
    val strY: Int? = y as? Int
    println(strY)
    val strX: String? = x as? String


//    if (x !is String || x.length === 0){
//        return
//    }


}

class Car(name: String, var model: String, var color: String) {
    var name: String = name.trim()
    fun move(): Unit = println("The car $name started moving")
    fun stop(): Unit = println("The car $name stopped moving")

}

class User(name: String, var age: Int) {
    var isAllowedToDrink: Boolean
    var userName: String

    init {
        userName =
            name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        isAllowedToDrink = age > 18

        println("User Name $userName")
        println("isAllowed $isAllowedToDrink")


    }

    fun greet() {
        println("Welcome $userName")
    }
}

class Lamp(private val lampName: String) {
    private var isOn: Boolean = false
    fun turnOn() {
        isOn = true
    }

    fun turnOff() {
        isOn = false
    }

    fun displayLightStatus(): String = "$lampName lamp is " + if (isOn) "on." else "off."

}

// Getters and Setters

//class Person {
//    var name: String = ""
//
//        get() = name
//
//        set(value) {
//            name = value
//        }
//
//
//}

