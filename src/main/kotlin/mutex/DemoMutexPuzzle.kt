package mutex

import java.util.concurrent.locks.ReentrantLock

val mutex = ReentrantLock()

fun main() {
    val thread1 = Thread {
        repeat(5) {
            try {
                mutex.lock()
                println("Thread 1: $it")
                Thread.sleep(100)
                mutex.unlock()
            } catch (_: InterruptedException) {
            }
        }
    }

    val thread2 = Thread {
        repeat(5) {
            try {
                mutex.lock()
                println("Thread 2: $it")
                Thread.sleep(100)
                mutex.unlock()
            } catch (_: InterruptedException) {
            }
        }
    }

    thread1.start()
    thread2.start()

    thread1.join()
    thread2.join()
}