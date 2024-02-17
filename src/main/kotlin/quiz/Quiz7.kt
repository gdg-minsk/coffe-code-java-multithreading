package quiz

/**
 * Does synchronized ensure memory visibility?
 * How can we fix the above code using synchronization?
 */
class Quiz7 {

    var myvalue: Int = 2
    var done: Boolean = false

    fun thread1() {
        synchronized(this) {
            while (!done);
            println(myvalue)
        }
    }

    fun thread2() {
        myvalue = 5
        done = true
    }
}