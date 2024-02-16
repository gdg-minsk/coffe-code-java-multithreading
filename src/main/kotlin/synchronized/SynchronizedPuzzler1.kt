package synchronized

class Counter {
    private var value = 0

    fun increment() {
        synchronized(this) {
            value++
            println("Thread ${Thread.currentThread().id}: $value")
        }
    }
}

fun main() {
    val counter = Counter()

    val thread1 = Thread {
        repeat(5) {
            counter.increment()
            Thread.sleep(100)
        }
    }

    val thread2 = Thread {
        repeat(5) {
            counter.increment()
            Thread.sleep(100)
        }
    }

    thread1.start()
    thread2.start()

    thread1.join()
    thread2.join()
}