package practice

fun substringCheck(inputArray: List<String>, subString: String): MutableList<String> {
    val resultArr = mutableListOf<String>()
    for (inputElement in inputArray) {
        if (subString in inputElement && inputElement !in resultArr) resultArr.add(inputElement)
    }
    return resultArr
}
