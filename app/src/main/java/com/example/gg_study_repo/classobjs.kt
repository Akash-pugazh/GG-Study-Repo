package com.example.gg_study_repo

import java.util.Locale

class Empty {
    var x: Int = 0
}

fun main(args: Array<String>) {
    val emptyObject = Empty()
    emptyObject.x = 12

    val pugazh = InstaUser("Aakash", "Pugazh")
    println(pugazh.fName)

    val muthu: Person = Person("Muthu")
    val aakash = Person("Aakash", muthu)

    var data = Admin("Aakash", "SuperUser")
    data.greet()

    val myHouse = House("Green", 2)
    println(myHouse.rooms)


    val ambaniMall = Mall("Ambani", 1, 100.0, mapOf(1 to "Akash"))
    println(ambaniMall.color)
    println(ambaniMall.ownerPrompt())

    val aakashAccount = Account("Aakash")

    Calculator.sum(1, 2)

    val myDatabase = Database.getInstance()
    val myCloneDatabase = Database.getInstance()

    println(myDatabase)
    println(myCloneDatabase)


    println(SingletonDatabase)
    println(SingletonDatabase)


    val secondaryConsUser = LazyUser("SecondaryConsUser")

    secondaryConsUser.childrenName = "Jith"
    println(secondaryConsUser.childrenName)

    val ajay = LazyUser("Ajay", "Din", 12)
//    lazy Initialization
    val vijay by lazy {
        LazyUser("Vijay", "Din", 12)
    }
    println(vijay.firstName)

    println(Direction.EAST.name)
    println(Direction.EAST.direction)

    for (direction in Direction.entries) {
        println(direction.direction + direction.distance)
    }
    Direction.EAST.printData()

    val listView = ListView(arrayOf("Hello", "Hi"))
    listView.ListViewItem().displayItem(1)


    val myPlane = Plane("KingFisher", "White", 12)
    println(myPlane.start())


}

class InstaUser(firstName: String, val lastName: String) {
    val fName = firstName

    init {
        println("Insta User Initialized $fName")
    }
}


class Owner(val pets: MutableList<Pet> = mutableListOf()) {}

class Pet {
    constructor(owner: Owner) {
        owner.pets.add(this)
    }
}

//class Person(val name: String) {
//    val children: MutableList<Person> = mutableListOf()
//    constructor(name: String, parent: Person) : this(name) {
//        parent.children.add(this)
//    }
//}


class Person(val name: String) {
    val children = mutableListOf<Person>()

    constructor(name: String, parent: Person) : this(name) {
        parent.children.add(this)
    }

}


// Abstract class abs keywrd
// Inside mem and prop may be abs

abstract class Student {
    abstract fun greetStudent(): String
}

class ItStudent : Student() {
    override fun greetStudent(): String {
        return "Hello It Student"
    }
}

// To inherit base class should have open keyword coz all class are default to final here

open class AppUser(userName: String) {
    val _uname = userName

    init {
        println("Welcome $_uname")
    }

    open fun greet(): String {
        return "Hello App User"
    }
}

class Admin(userName: String, val role: String) : AppUser(userName) {
    val userName = userName
    override fun greet(): String {
        return "Welcome ra Admin ehhh $userName"
    }
}

class House(color: String, rooms: Int) {
    var houseColor: String
    var rooms: Int = 2
        get() = 100
        set(value) {
            field = value * 2
        }

    init {
        this.houseColor = color
        println(houseColor)
    }

    init {
        this.rooms = rooms
        println(rooms)
    }

    constructor(rooms: Int, color: String) : this(color, rooms) {

    }

    var windows: Int = 0

    constructor(rooms: Int, color: String, windows: Int) : this(rooms, color) {
        this.windows = windows
    }


}


open class Building(marketPrice: Double) {
    open var owner: String = ""
    open val rooms: Int = 0
    var color: String = ""

    open fun ownerPrompt(): String {
        return "Hello Owner $owner"
    }

}

// if not open is used for property in the parent class it cant be overrided
open class Mall(
    override var owner: String,
    override val rooms: Int,
    marketPrice: Double,
    people: Map<Int, String>
) : Building(marketPrice) {

    var people: Map<Int, String>

    init {
        this.people = people
    }

    override fun ownerPrompt(): String {
//        return super.ownerPrompt()
//        This will use the parent returned values
        return "Hello this is Mall"
    }
}

open class Account(holderName: String) : AccountFunctions() {
    val holderName = holderName
    private var balance = 0
    override val notificationsSent = 0

    override fun sendNotification() {
        TODO("Not yet implemented")
    }

    private fun depositAmount(amount: Int) {
        this.balance += amount
    }

    protected fun getBalance(): Int {
        return this.balance
    }

    private fun withdraw(amount: Int) {
        this.balance -= amount
    }
}

open class testAccount : AccountFunctions() {
    override val notificationsSent: Int = 0

    override fun sendNotification() {
        TODO("Not yet implemented")
    }

}

abstract class AccountFunctions {
    abstract val notificationsSent: Int
    abstract fun sendNotification()

    open var loanPending = 0
}

interface Maintenace {
    val isInMaintenace: Boolean
}


class Calculator {
    //    Companion object can be created to access the class properties and member functions without creation of classes
    companion object {
        fun sum(num1: Int, num2: Int): Int {
            return num1 + num2
        }
    }
}


class Database private constructor() {
    companion object {
        private var instance: Database? = null

        fun getInstance(): Database? {
            if (instance == null) {
                instance = Database()
            }
            return instance
        }

    }
}

object SingletonDatabase {
    init {
        println("Database created")
    }
}


class LazyUser(firstName: String, val lastName: String, val age: Int) {


    var firstName: String = firstName
        get() {
            return "First Name fo User : $field"
        }
        set(value) {
            field = value.lowercase(Locale.ROOT)
        }

    lateinit var childrenName: String

    constructor(firstName: String) : this(firstName, "", 0) {
        println("Secondary Constructor 1 used")
    }

    constructor(firstName: String, age: Int) : this(firstName, "", age) {
        println("Secondary construcror 2 used")
    }

    init {
        println("User $firstName was created")
    }
}


enum class Direction(var direction: String, var distance: Int) {
    NORTH("North", 10),
    SOUTH("South", 10),
    EAST("East", 10),
    WEST("West", 10);

    fun printData() {
        println("Direction is $direction Distance is $distance")
    }
}


// Inner Class

class ListView(val items: Array<String>) {
    inner class ListViewItem() {
        fun displayItem(position: Int) {
            println(items[position])
        }
    }
}

enum class TransactionType() {
    WITHDRAW,
    DEPOSIT
}

open class Transaction {
    companion object {
        fun transact(transactionType: TransactionType, amount: Int) {
            when (transactionType) {
                TransactionType.DEPOSIT -> {
                    deposit(amount)
                }

                TransactionType.WITHDRAW -> {

                }

                else -> {
                    println("Failed Transaction, Method Does not exist")
                }
            }
        }

        fun deposit(amount: Int) {

        }

        fun withDraw(amount: Int) {

        }

    }

}

class BankAccount(
    val userName: String,
    var balance: Int = 0,
    val transactions: MutableList<Transaction> = mutableListOf<Transaction>()
) : Transaction() {


}


open class Vehicle(val name: String, val color: String) {
    open fun start(): String {
        return "$name is started"
    }

    open fun stop(): String {
        return "$name is stopped moving"
    }
}

class Plane(name: String, color: String, val engines: Int) : Vehicle(name, color) {
    override fun start(): String {
        return "The $name plane started flying"
    }

    override fun stop(): String {
        return "The $name plane has landed"
    }

}


// Abstract Classes

abstract class Vehicle1 {
    abstract fun start()
    abstract fun stop()
}

class Bike: Vehicle1() {
    override fun start() {

    }
    override fun stop() {

    }
}




















