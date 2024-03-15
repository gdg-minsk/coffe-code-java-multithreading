package quiz.solution

/**
 * Task.
 * Thread t1 calls printFirst(), thread t2 calls printSecond(), and thread t3 calls printThird().
 * The threads can run in any order. You have to synchronize the threads so that the functions
 * printFirst(), printSecond() and printThird() are executed in order.
 */

class SolutionOrderPrinting {
    private var count: Int = 1
    private val lock = Object()

    @Throws(InterruptedException::class)
    fun printFirst() {
        synchronized(lock) {
            println("First")
            count++
            lock.notifyAll()
        }
    }

    @Throws(InterruptedException::class)
    fun printSecond() {
        synchronized(lock) {
            while (count != 2) {
                lock.wait()
            }
            println("Second")
            count++
            lock.notifyAll()
        }
    }

    @Throws(InterruptedException::class)
    fun printThird() {
        synchronized(lock) {
            while (count != 3) {
                lock.wait()
            }
            println("Third")
        }
    }
}

fun main(args: Array<String>) {
    val printing = SolutionOrderPrinting()
    val thread1 = Thread {
        printing.printFirst()
    }
    val thread2 = Thread {
        printing.printSecond()
    }
    val thread3 = Thread {
        printing.printThird()
    }

    thread1.start()
    thread2.start()
    thread3.start()

    thread1.join()
    thread2.join()
    thread3.join()
}
