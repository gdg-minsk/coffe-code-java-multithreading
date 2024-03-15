package quiz

import quiz.solution.SolutionPrintNumberSeries

/**
 * You are required to write a program which takes a user input n and outputs the number series
 * using three threads. The three threads work together to print zero, even and odd numbers.
 * The threads should be synchronized so that the functions PrintZero(), PrintOdd() and PrintEven()
 * are executed in an order.
 */
class PrintNumberSeries(
    private val n: Int
) {

    fun printZero() {
    }

    fun printOdd() {
    }

    fun printEven() {
    }
}

fun main(args: Array<String>) {
    val printing = SolutionPrintNumberSeries(5)
    val thread1 = Thread {
        printing.printZero()
    }
    val thread2 = Thread {
        printing.printEven()
    }
    val thread3 = Thread {
        printing.printOdd()
    }

    thread1.start()
    thread2.start()
    thread3.start()

    thread1.join()
    thread2.join()
    thread3.join()
}