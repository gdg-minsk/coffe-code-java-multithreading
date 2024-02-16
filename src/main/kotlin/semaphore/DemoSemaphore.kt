package semaphore

import java.util.concurrent.Semaphore

fun main() {
    val semaphore = Semaphore(3) // Инициализация семафора с тремя разрешениями

    val thread1 = Thread {
        repeat(5) {
            try {
                semaphore.acquire() // Захват разрешения
                println("Thread 1: $it")
                Thread.sleep(100)
            } finally {
                semaphore.release() // Освобождение разрешения
            }
        }
    }

    val thread2 = Thread {
        repeat(5) {
            try {
                semaphore.release()
                semaphore.acquire()
                println("Thread 2: $it")
                Thread.sleep(100)
            } finally {
                semaphore.release()
            }
        }
    }

    val thread3 = Thread {
        repeat(5) {
            try {
                semaphore.acquire()
                println("Thread 3: $it")
                Thread.sleep(100)
            } finally {
                semaphore.release()
            }
        }
    }

    thread1.start()
    thread2.start()
    thread3.start()

    thread1.join()
    thread2.join()
    thread3.join()
}