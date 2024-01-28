package com.example.gg_study_repo

fun main() {

    val dhoni = CricketPlayer("Dhoni")
    val kohli = CricketPlayer("Kohli")

    dhoni.greetPlayer()
    kohli.greetPlayer()

    val indiaTeam = Team<CricketPlayer>("India", mutableListOf(dhoni))
    indiaTeam.addPlayer(kohli)
    for (player in indiaTeam.players) {
//        println(player.name)
    }

    val messi = FootballPlayer("Messi")
//    indiaTeam.addPlayer(messi)

    val barcelano = Team<FootballPlayer>("Barcelano", mutableListOf(
        FootballPlayer("Messi"), DisttrictFootballPlayer("da")
    ))


}


// in -> contravariant it can able to add el or the parent els
// out -> covariance it can able to add el or the child inherited els

class Team<T>(val teamName: String, val players: MutableList<in T> = mutableListOf()) {
    fun addPlayer(player: T) {
        if (!players.contains(player)) {
            players.add(player)
//            println("This player ${player.name} is added to the team ")
        } else println("This player is already in team")
    }
}

open class Player(val name: String) {
    open fun greetPlayer() {
        println("Welcome Player $name")
    }
}

class CricketPlayer(name: String) : Player(name) {
    override fun greetPlayer() {
        println("Welcome cricket player $name")
    }
}

open class FootballPlayer(name: String) : Player(name) {
    override fun greetPlayer() {
        println("Welcome Football player $name")
    }
}

class DisttrictFootballPlayer(name: String): FootballPlayer(name)

open class GamesPlayer(name: String): Player(name)
class CsgoPlayer(name: String): GamesPlayer(name)

interface Listener {
}
