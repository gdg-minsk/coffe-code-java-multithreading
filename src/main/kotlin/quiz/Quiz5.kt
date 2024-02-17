package quiz

/**
 * What will be the output by thread1?
 */
class MemoryVisibility {
    var myvalue: Int = 2
    var done: Boolean = false

    fun thread1() {
        while (!done);
        println(myvalue)
    }

    fun thread2() {
        myvalue = 5
        done = true
    }
}

fun main() {
    val mv = MemoryVisibility()

    val thread1 = Thread {
        mv.thread1()
    }

    val thread2 = Thread {
        mv.thread2()
    }

    thread1.start()
    thread2.start()

    thread1.join()
    thread2.join()
}