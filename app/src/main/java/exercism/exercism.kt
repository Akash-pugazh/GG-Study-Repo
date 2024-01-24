package ExercismExercises

import java.util.*

fun twoFer(friendName: String = "You"): String {
    return "One for $friendName and one for me"
}

fun hammingDistance(dna1: String, dna2: String): Int {
    if (dna1.length != dna2.length) throw Exception("Dna lengths don't match")
    var hammingDistanceResult: Int = 0
    var ptr: Int = 0
    while (ptr != dna1.length - 1) {
        if (dna1[ptr] != dna2[ptr]) hammingDistanceResult++
        ptr++
    }
    return hammingDistanceResult
}

fun scrabbleScore(word: String): Int {
    val scoresLettersMap = hashMapOf<Array<Char>, Int>().apply {
        this[arrayOf('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T')] = 1
        this[arrayOf('D', 'G')] = 2
        this[arrayOf('B', 'C', 'M', 'P')] = 3
        this[arrayOf('F', 'H', 'V', 'W', 'Y')] = 4
        this[arrayOf('K')] = 5
        this[arrayOf('J', 'X')] = 8
        this[arrayOf('Q', 'Z')] = 10
    }
    val scoresLetterMapKeys: Array<Array<Char>> = scoresLettersMap.keys.toTypedArray()
    var scoresResult: Int = 0
    for (character: Char in word.uppercase(Locale.getDefault())){
        for (key:Array<Char> in scoresLetterMapKeys){
            if (key.contains(character)) scoresResult += scoresLettersMap.getOrDefault(key, 0)
        }
    }
    return scoresResult
}

fun matrix(martixArray: Array<Array<Int>>){
    var arrayPtr: Int = 0
    var elementPtr: Int = 0

//    while (arrayPtr !=)

}

fun main(args: Array<String>) {
    println(twoFer("Abi"))
    println(hammingDistance("GAGCCTACTAACGGGAT", "CATCGTAATGACGGCCT"))
    println(scrabbleScore("cabbage"))
}