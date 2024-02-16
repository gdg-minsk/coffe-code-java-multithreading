package synchronized

fun main(args: Array<String>) {
    var count = 0
    var ready = false

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