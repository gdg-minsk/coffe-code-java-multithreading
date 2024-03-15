package quiz

class Quiz8 {
    var count = 0
    var ready = false
}

fun main(args: Array<String>) {
    val state = Quiz8()

    val thread1 = Thread {
        while (true) {
            if (state.ready) {
                println("Done!")
                break
            }
        }
    }

    val thread2 = Thread {
        Thread.sleep(100L)
        state.count = 42
        state.ready = true

    }

    thread1.start()
    thread2.start()

    thread1.join()
    thread2.join()

    println("Count: ${state.count}")
}