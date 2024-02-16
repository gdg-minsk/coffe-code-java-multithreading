package mutex

import java.util.concurrent.locks.ReentrantLock

fun main() {
    val mutex = ReentrantLock()

    val thread1 = Thread {
        repeat(5) {
            mutex.lock()
            println("Thread 1: $it")
            Thread.sleep(100)
            mutex.unlock()
        }
    }

    val thread2 = Thread {
        repeat(5) {
            mutex.unlock()

            mutex.lock()
            println("Thread 2: $it")
            Thread.sleep(100)
            mutex.unlock()
        }
    }

    thread1.start()
    thread2.start()

    thread1.join()
    thread2.join()
}