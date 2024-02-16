package semaphore

class CountingSemaphoreExample(
    private val maxCount: Int // max permits to give out
) {
    private var usedPermits: Int = 0 // permits given out

    fun acquire() {
    }

    fun release() {
    }
}