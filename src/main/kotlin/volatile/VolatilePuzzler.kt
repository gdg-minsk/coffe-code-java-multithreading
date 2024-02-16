package volatile

object VolatilePuzzler {
    private var count = 0
    private var ready = false

    fun main(args: Array<String>) {
        val thread1 = Thread {
            while (true) {
                if (ready) {
                    println("Done!")
                    break
                }
            }
        }

        val thread2 = Thread {
            Thread.sleep(100L)
            count = 42
            ready = true

        }

        thread1.start()
        thread2.start()

        thread1.join()
        thread2.join()

        println("Count: $count")
    }
}