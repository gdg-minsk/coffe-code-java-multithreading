package demo

class CountingSemaphore(// max permits to give out
    private val maxCount: Int
) {
    private var usedPermits: Int = 0 // permits given out
    private val lock = Object()

    fun acquire() {
        synchronized(lock) {
            while (usedPermits == maxCount) lock.wait()

            usedPermits++
            lock.notify()
        }
    }

    fun release() {
        synchronized(lock) {
            while (usedPermits == 0) lock.wait()

            usedPermits--
            lock.notify()
        }
    }
}