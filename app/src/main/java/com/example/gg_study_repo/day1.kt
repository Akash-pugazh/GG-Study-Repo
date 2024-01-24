import java.util.TreeMap

class Person(var name: String) {
    //    Methods in class
    fun greet() {
        println("Welcome $name 🙌")
    }
}

fun main(args: Array<String>) {
    print("Hello World!")

//    No new keyword in creating instances
    val aakash = Person("Aakash")
//    Calling with constructor


//    aakash = 23
//    val is immutable

    aakash.name = "Aakash"
//    Property name in Person class is var, so it is re assignable
    println(aakash.name)

//    calling methods
//    aakash.greet()

//    println(calculator("kdjf", 10, 20))
//    tryStatements()

//    loops()

//    moreStuff()


    val newArr: Array<Int> = arrayOf(1, 2, 3, 4)
    println(newArr.contentToString())

//    Delete Element

    val deleteIndex: Int = 1
    val afterDeletionArray = newArr.sliceArray(0..<deleteIndex) + newArr.sliceArray(deleteIndex + 1 until newArr.size)
    println(afterDeletionArray.contentToString())


    val a: Int = 10
    val boxedA: Int = a
    val anotherBoxedA: Int = a

    println(a == boxedA)

    val testArray = Array(5) {
        i -> i + 1
    }
    testArray.forEach { num -> println(num  ) }


}


fun varAndMutable() {
//    Variables declared using var or val

//    var -> changed later
//    val -> can't be changed later

    val question = "What is your name ?"
//    In case of initialization in one line and declaring value in another line explicit type should be specified

//    var answer
//    give error

    var answer: String

    println("The Question is $question")

    answer = "Aakash"
    println("Before Shadowing $answer")


    answer = "Akash"
    println("The Answer is $answer")


//    Shadowing : The term of declaring the same variable the last one will shadow the previous one
//    Not possible in immutable -> val
    var age: Byte = 18
//    Any variable is not used allows shadowing of another variable is a warning (redundant)
    age = 20

    println(age)

    val dateOfBirth: String = "13/07/2003"
//    dateOfBirth = "11/06/2003"


//    String Interpolation:
//    use $var name for simple ones
//    use $classname.property for complex ones (dot notation)
}

fun conditionals() {
    val age = 20
//    Normal style of conditions
    var isAllowed: Boolean
    if (age > 18) {
        isAllowed = true
    } else {
        isAllowed = false
    }
    println(isAllowed)

    var gender = "Male"

//    Ternary style of conditioning this inside code block will be returned as if statement is statement
    val checkGenderAndAllow: Boolean = if (gender == "Male") {
        true
    } else {
        true
    }

    println("Check Gender and allow true if male else false : $checkGenderAndAllow")

}

fun nullableValues() {
//    ? at end to indicate this can contain null values else it will not permit adding null values
    val name: String?
    name = null

    val personOrNull: Person? = Person("Aakash")
//    This one is instance of person or null so inorder to access a null added properties

//    println(personOrNull.name)
//    This will throw error so use safe access operator ?. as in the Javascript optional chaining, so if the object is not null it will
//    access the property values else null is result

    println(personOrNull?.name)

}

fun calculator(operation: String, operand1: Int, operand2: Int): Int {
    return when (operation) {
        "+" -> operand1 + operand2
        "-" -> operand1 - operand2
        "*" -> operand1 * operand2
        "/" -> operand1 / operand2
        else -> throw IllegalArgumentException("Invalid operation: $operation")
    }
}

fun tryStatements() {
//    This will try the expression statement else any error or exception raises it should be catched and handled
//    This is also a statement like using if that return in case of ternary style

    val testStr: String = "12fdsf"
    val testInt: Int? = try {
        Integer.parseInt(testStr)
    } catch (e: NumberFormatException) {
        null
    }

    println(testInt)
}

fun loops() {
    var i = 0
    while (i <= 5) {
        println(i)
        i++
    }

    var j = 0
    do {
        println("I will run once")
        println(j)
        j++
    } while (j <= 10)

    for (forInterger in 0..1) {
        println(forInterger)
    }
//    step works with range skips number based on steps
    for (x in 0..10 step 2){
        println(x)
    }

//    Down to for reverse iteration no range will not work here
    for (value in 10 downTo 1){
        println(value)
    }

//    until -> used to leave the last number 1,2,3,4,5,6,7,8,9
    for (y in 1 until 10){
        println(y)
    }

//    Creation of list and iteration over list using in
    var numbersList = listOf(312,3,12,3,13)
    for (num in numbersList){
        println(num)
    }

//    Treemap
    var personAgeMap = TreeMap<String, Int>()
    personAgeMap["Aakash"] = 12
    personAgeMap["Pugazh"] = 19

    for ((name, age) in personAgeMap){
        println("$name is $age years old")
    }

//    A list has property that gives length of list similar to len -> .indices
//    Nope .indices will give you the range, so it can be iterated using it
    println("Length of the index is ${numbersList.indices}")
//    .size is similar to the length
    println(numbersList.size)
    for (indexVal in numbersList.indices){
        println(indexVal)
    }

    for ((index, element) in numbersList.withIndex()){
        println("$element is at $index")
    }
}

class Man(var name: String){

}

fun Man.greet(){
    println("Hello $name")
}


fun moreStuff(){
    var aakash = Man("Aakash")
    aakash.greet()
}




