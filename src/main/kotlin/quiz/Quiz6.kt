package quiz

/**
 * Will the following change guarantee that thread1
 * sees the changes made to shared variables by thread2?
 */
class Quiz6 {

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