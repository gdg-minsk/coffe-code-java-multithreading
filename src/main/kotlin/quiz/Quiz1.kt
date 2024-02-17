package quiz

/**
 * Given the code snippet below, how many times will the innerThread print its messages?
 */
fun main() {
    val innerThread = Thread {
        for (i in 0..99) {
            println("I am a new thread !")
        }
    }
    innerThread.isDaemon = true

    innerThread.start()
    println("Main thread exiting")
}