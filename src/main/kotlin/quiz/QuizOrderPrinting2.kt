package quiz

/**
 * Task.
 * Thread t1 calls printFirst(), thread t2 calls printSecond(), and thread t3 calls printThird().
 * The threads can run in any order. You have to synchronize the threads so that the functions
 * printFirst(), printSecond() and printThird() are executed in order.
 */
class OrderedPrinting2 {
    fun printFirst() {
        println("First")
    }

    fun printSecond() {
        println("Second")
    }

    fun printThird() {
        println("Third")
    }
}

fun main(args: Array<String>) {
    val printing = OrderedPrinting2()
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
