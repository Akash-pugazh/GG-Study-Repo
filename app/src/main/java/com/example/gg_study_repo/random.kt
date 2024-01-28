package com.example.gg_study_repo


abstract class Shape(shapeName: String) {
    var _shapeName = shapeName
//        get() {
//            return "ShapeName : $field"
//        }

    constructor(shapeName: String, vararg dimensions: Int) : this(shapeName)

    init {
        println("This is from super class !")
    }

    protected open fun getShapeName(): String {
        println("This is a $_shapeName")
        return "This is a $_shapeName"
    }

    fun changeShapeName(newShapeName: String) {
        _shapeName = newShapeName
    }

    abstract fun area(): Int

}

class Circle(val radius: Int, val diameter: Int) : Shape("Circle") {

    companion object {
        fun generateInfo() {
            println("This is a circle class, It has constructor with radius, and members are area function")
        }
    }

    private val PI = 3.14
//    fun area() {
//        println(3.14 * radius * radius)
//    }

    constructor(r: Int) : this(r, 2 * r)

    constructor(r: Double, diameter: Double) : this(r.toInt(), diameter.toInt())

    public override fun getShapeName(): String {
        println("${super.getShapeName()} This is from Child class")
        return ""
    }

    override fun area(): Int {
        println("Area of $_shapeName : ${PI * radius * radius}")
        return (Constants.PI * radius * radius).toInt()
    }
//    Same fun name but different params or different datatypes provided

    fun area(message: String) {
        println("I am a Overloaded Function")
        println("Hello There $message")
        println("Area : ${PI * radius * radius}")
    }

    //    I am also overloaded but with datatypes
    fun area(message: Int) {
        println("I am overloaded with datatype")
        println("Your provided integer message $message")
        println("Area : ${Constants.PI * radius * radius}")
    }


}


object Constants {
    val PI: Float = 3.14F
}

fun main() {

    val simpleExp = 3 > 4 || 4 > 3 && 4 <= 4
    println(simpleExp)

    val bool = true
    val x = 9
    val y = 3
    val z = 9
    val hardExp = !(x != z) && bool || z > (x + y) && (!bool || y < z)
    println(hardExp)

    val myCircle = Circle(2)
//    myCircle.PI
    myCircle.getShapeName()
    myCircle.changeShapeName("Small Circle")
    println(myCircle._shapeName)
    myCircle.area()

//    Shape("dsa")

    val radiusOnlyCircle = Circle(1)
    radiusOnlyCircle.area()
    val testCircle = Circle(1.2, 2.3)
    testCircle.area("Aakash")

    Circle.generateInfo()

    val side1 = 10
    val side2 = 10
    val side3 = 10
    val side4 = 10


    val myDiamond = object : Shape("Diamond", side1, side2, side3, side4) {
        init {
            println("Diamond initialized Side1 : $side1, Side2 : $side2, Side3 : $side3, Side4 : $side4")
        }

        override fun area(): Int {
            println("Area of diamond : ")
            return 1
        }

        fun isDiamond() = side1 == side2 && side1 == side3 && side1 == side4

    }
    myDiamond.area()
    println(myDiamond.isDiamond())

    println("Input A Number ")

    val inputVal = try {
        readLine()?.toInt()
    } catch (e: NumberFormatException) {
        println("Please input a valid integer value")
        0
    } finally {
        println("Completed input eval")
    }

    println(inputVal)

    val testDivide = try {
        myDivisionFun(1, 0)
    } catch (e: Exception) {
        println(e) // This will give a exception obj
        println(e.message)
        0
    } finally {
        println("Completed Divide Function")
    }
    println(testDivide)

    val myList = (1..20).toList()
    val evenList = myList.filter { it % 2 == 0 }
    println(evenList)


    val shapesList = listOf<Shape>(Circle(1), Circle(2), Circle(3), Circle(4))
    val res = shapesList.customFilter { it.area() > Constants.PI }
    println(res.toTypedArray())

    println(myList.customGenericFilter { it % 2 == 0 })

    val custGenericClass = CustomGenericTypes(1, "Hello", true)
    custGenericClass.printTypes()

}

// Own lambda extension fn
fun List<Shape>.customFilter(filterFn: (Shape) -> (Boolean)): List<Shape> {
    val resultList = mutableListOf<Shape>()
    for (shape in this) {
        if (filterFn(shape)) {
            resultList.add(shape)
        }
    }
    return resultList
}


fun myDivisionFun(numerator: Int, denominator: Int): Int {
    if (denominator == 0) {
        throw DivisionByZeroException()
    }
    return numerator / denominator
}

class DivisionByZeroException :
    Exception("You cannot divide by zero, Please choose a different number")


fun <T : Number> List<T>.customGenericFilter(filterFn: (T) -> (Boolean)): List<T> {
    val res = mutableListOf<T>()
    for (item in this) {
        if (filterFn(item)){
            res.add(item)
        }
    }
    return res
}

class CustomGenericTypes<A :Any, B: Any, C: Any> (
    val first: A,
    val second: B,
    val third: C
) {
    fun printTypes() {
        println("First Type is ${first::class}")
        println("Second Type is ${second::class}")
        println("Third Type is ${third::class}")
    }
}




















