package demo

class State {
    var x = 0
    var y = 0
}

fun main(args: Array<String>) {
    val state = State()
    val t1 = Thread {
        state.x = 1
        println("y: ${state.y}")
    }
    val t2 = Thread {
        state.y = 1
        println("x: ${state.x}")
    }

    t1.start()
    t2.start()

    t1.join()
    t2.join()
}
