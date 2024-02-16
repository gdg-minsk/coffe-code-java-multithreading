package demo

class State {
    var x = 0
    var y = 0
}
fun main(args: Array<String>) {
    val state = State()
    val t1 = Thread {
        state.x = 1
        println("y1: ${state.y}")
        println("x1: ${state.x}")
    }
    val t2 = Thread {
        state.y = 1
        println("x2: ${state.x}")
        println("y2: ${state.y}")
    }

    t1.start()
    t2.start()

    t1.join()
    t2.join()
}
