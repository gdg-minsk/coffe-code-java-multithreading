package local

class UnsafeCounter {
    var counter: ThreadLocal<Int> = ThreadLocal.withInitial { 0 }

    fun increment() {
        counter.set(counter.get() + 1)
    }
}

fun main() {
    val usc = UnsafeCounter()
    val tasks = mutableListOf<Thread>()

    for (i in 0..99) {
        val t = Thread {
            for (j in 0..99) usc.increment()
            println(usc.counter.get())
        }
        tasks.add(t)
        t.start()
    }

    for (i in 0..99) {
        tasks[i].join()
    }

//    println(usc.counter.get())
}