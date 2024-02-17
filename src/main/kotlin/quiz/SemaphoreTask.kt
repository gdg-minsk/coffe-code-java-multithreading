package quiz

import java.util.Objects

class CountingSemaphoreExample(
    private val maxCount: Int // max permits to give out
) {
    private var usedPermits: Int = 0 // permits given out

    private val lock = Object()
    fun acquire() {
        synchronized(lock) {
            while (usedPermits == maxCount) {
                lock.wait()
            }

            usedPermits++
        }
    }

    fun release() {
        synchronized(lock) {
            if (usedPermits > 0) {
                usedPermits--

                lock.notifyAll()
            }
        }
    }
}