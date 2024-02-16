import java.util.*

private val random: Random = Random(System.currentTimeMillis())

fun main(args: Array<String>) {
    // create object of unsafe counter

    val badCounter = ThreadUnsafeCounter()

    // setup thread1 to increment the badCounter 200 times
    val thread1 = Thread {
        for (i in 0..99) {
            badCounter.increment()
            badCounter.printFinalCounterValue()
            sleepRandomlyForLessThan10Secs()
        }
    }
    thread1.isDaemon=true

    // setup thread2 to decrement the badCounter 200 times
    val thread2 = Thread {
        for (i in 0..99) {
            badCounter.decrement()
            badCounter.printFinalCounterValue()
            sleepRandomlyForLessThan10Secs()
        }
    }

    thread2.isDaemon=true

    // run both threads
    thread1.start()
    thread2.start()

    // wait for t1 and t2 to complete.
    thread1.join()
    thread2.join()

    // print final value of counter
    Thread.sleep(100L)
    badCounter.printFinalCounterValue()
}

private fun sleepRandomlyForLessThan10Secs() {
    try {
        Thread.sleep(random.nextInt(10).toLong())
    } catch (_: InterruptedException) {
    }
}

internal class ThreadUnsafeCounter {
    private var count: Int = 0

    fun increment() {
        count++
    }

    fun decrement() {
        count--
    }

    fun printFinalCounterValue() {
        println("counter is: $count")
    }
}