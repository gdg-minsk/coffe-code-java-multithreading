package reentrantlock

import java.util.concurrent.locks.ReentrantLock

@Throws(Exception::class)
fun main(args: Array<String>) {
    val lock = ReentrantLock()
    val threadA = Thread { threadA(lock) }
    val threadB = Thread { threadB(lock) }

    try {
        lock.lock()
        lock.lock()
        lock.lock()

        println("Main thread lock hold count = " + lock.holdCount)

        // submit other threads
        threadA.start()
        threadB.start()

        // release locks slowly
        for (i in 0..2) {
            Thread.sleep(50)
            lock.unlock()
        }

        println("Main thread released lock. Lock hold count = " + lock.holdCount)
        threadA.join()
        threadB.join()
    } finally {
        // Make sure to release the locks if an exception occurs
        for (i in 0 until lock.holdCount) {
            lock.unlock()
        }
    }
}

fun threadB(lock: ReentrantLock) {
    println("threadB is trying to acquire the lock" + lock.isLocked)
    lock.lock()
    println("threadB acquired the lock" + lock.isLocked)
    lock.unlock()
}

fun threadA(lock: ReentrantLock) {
    val name = "THREAD-A"
    Thread.currentThread().name = name
    var keepTrying = true

    println("Is lock owned by any other thread = " + lock.isLocked)

    while (keepTrying) {
        println("$name trying to acquire lock")

        if (lock.tryLock()) {
            try {
                println("$name acquired lock")
                keepTrying = false
            } finally {
                lock.unlock()
                println("$name released lock")
            }
        } else {
            println(name + " failed to acquire lock. Other threads waiting = " + lock.queueLength)
        }

        try {
            Thread.sleep(20)
        } catch (ie: InterruptedException) {
            // ignore exception.
        }
    }
}