fun greet(name: String): String {
    return "Hello $name"
}
fun main(args: Array<String>){
    val greetMesageForAakash = greet("Aakash")
//    println(greetMesageForAakash)

//    println(sumOfTwoInt(1, 2))
    printMessage("User message")
}

// function expressions
// This will return the values
fun sumOfTwoInt(a: Int, b: Int): Int = a + b

fun max(num1: Int, num2: Int): Int? = if (num1 > num2) num1 else if (num1 == num2) num2 else null

// Default params can be set
fun printMessage(msg: String = "Hii, I'm a default message"){
    print(msg)
}

// Extension Functions
