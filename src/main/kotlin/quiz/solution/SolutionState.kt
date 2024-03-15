package quiz.solution

/**
 * How to print always 1:1
 */
class State {
    var x = 0
    var y = 0
}
fun main(args: Array<String>) {
    val obj = Object()
    var flag1 = false
    var flag2 = false

    val state = State()
    val t1 = Thread {
        synchronized(obj) {
            state.x = 1

            flag2 = true
            obj.notifyAll()

            while (!flag1) {
                obj.wait()
            }

            println("y: ${state.y}")
        }
    }
    val t2 = Thread {
        synchronized(obj) {
            state.y = 1

            while (!flag2) {
                obj.wait()
            }

            println("x: ${state.x}")

            flag1 = true
            obj.notifyAll()
        }
    }

    t1.start()
    t2.start()

    t1.join()
    t2.join()
}