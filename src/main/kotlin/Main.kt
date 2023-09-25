fun main(args: Array<String>) {
    println(getDivisors(24))
}

fun factorial(number: Int): Int {
    return if (number == 1) 1 else number * factorial(number - 1)
}

fun factorialNew(n: Int): Int {
    var result = 1
    if (n == 0) {
        result
    } else {
        for (i in 1..n) {
            result *= i
        }
    }
    return result
}

fun sumPositiveNumbers(numberList: List<Int>): Int {
    val positiveList = numberList.filter { it > 0 }
    var result = 0
    for (i in positiveList.indices) {
        result += positiveList[i]
    }
    return result
}

fun checkSimpleNumber(n: Int): Boolean {
    if (n <= 1) return false else
        for (i in 2 until  n) {
            if (n % i == 0) return false
        }
    return true
}

fun getDivisors(n: Int): List<Int> {
    val resultList = mutableListOf<Int>()
    for (i in 1 .. n) {
        if (n % i == 0) resultList.add(i)
    }
    return resultList
}

// Напишите функцию на Kotlin для нахождения наибольшего общего делителя (НОД) двух чисел.