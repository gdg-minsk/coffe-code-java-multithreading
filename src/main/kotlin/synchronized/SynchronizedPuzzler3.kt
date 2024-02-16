package synchronized

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

fun execute() {
    val lock1: Lock = ReentrantLock()
    val lock2: Lock = ReentrantLock()

    Thread {
        synchronized(lock1) {
            println("Thread 1 acquired lock1")
            Thread.sleep(100) // Чтобы увеличить вероятность возникновения дедлока
            synchronized(lock2) {
                println("Thread 1 acquired lock2")
            }
        }
    }.start()

    Thread {
        synchronized(lock2) {
            println("Thread 2 acquired lock2")
            Thread.sleep(100) // Чтобы увеличить вероятность возникновения дедлока
            synchronized(lock1) {
                println("Thread 2 acquired lock1")
            }
        }
    }.start()
}