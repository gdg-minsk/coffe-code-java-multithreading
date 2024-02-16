package volatile

import kotlin.concurrent.Volatile

object DemoVolatile {
    // volatile doesn't imply thread-safety!
    @Volatile
    var count: Int = 0

    @JvmStatic
    fun main(args: Array<String>) {
        val numThreads = 10
        val threads = mutableListOf<Thread>()

        for (i in 0..<numThreads) {
            threads.add(Thread { for (j in 0..999) count++ })
        }

        for (i in 0..<numThreads) {
            threads[i].start()
        }

        for (i in 0..<numThreads) {
            threads[i].join()
        }

        println("count = $count")
    }
}