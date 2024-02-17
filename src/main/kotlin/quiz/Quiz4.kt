package quiz

class Quiz4 {

    private var count = 0

    /**
     * If we synchronize the sum() method as follows, will it be thread-safe?
     */
    fun sum(vararg vals: Int): Int {
        val myLock = Any()
        synchronized(myLock) {
            count++
        }

        var total = 0
        for (i in vals.indices) {
            total += vals[i]
        }
        return total
    }
}