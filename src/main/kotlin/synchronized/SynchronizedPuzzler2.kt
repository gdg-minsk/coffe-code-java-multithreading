package synchronized

class SharedResource {
    companion object {
        private var counter = 0

        @Synchronized
        @JvmStatic
        fun increment() {
            counter++
            println("Thread ${Thread.currentThread().id}: $counter")
        }
    }
}

fun main() {
    val thread1 = Thread {
        repeat(5) {
            SharedResource.increment()
            Thread.sleep(100)
        }
    }

    val thread2 = Thread {
        repeat(5) {
            SharedResource.increment()
            Thread.sleep(100)
        }
    }

    thread1.start()
    thread2.start()

    thread1.join()
    thread2.join()
}