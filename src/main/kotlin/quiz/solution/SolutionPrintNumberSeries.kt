package quiz.solution

import java.util.concurrent.Semaphore

class SolutionPrintNumberSeries(private val n: Int) {
    private val zeroSem: Semaphore = Semaphore(1)
    private val oddSem: Semaphore = Semaphore(0)
    private val evenSem: Semaphore = Semaphore(0)

    fun printZero() {
        for (i in 0 until n) {
            zeroSem.acquire()
            print("0")
            // release oddSem if i is even or else release evenSem if i is odd
            (if (i % 2 == 0) oddSem else evenSem).release()
        }
    }

    fun printEven() {
        var i = 2
        while (i <= n) {
            evenSem.acquire()
            print(i)
            zeroSem.release()
            i += 2
        }
    }

    fun printOdd() {
        var i = 1
        while (i <= n) {
            oddSem.acquire()
            print(i)
            zeroSem.release()
            i += 2
        }
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