import quiz.solution.State

class State {
    var x = 0
    var y = 0
}

fun main(args: Array<String>) {
    val state = State()

    val lock = Object()

    val t1 = Thread {
        synchronized(lock) {
            state.x = 1
            lock.notify()
            while (state.y != 1){
                lock.wait()
            }
            println("y: ${state.y}")
        }
    }
    val t2 = Thread {
        synchronized(lock) {
            state.y = 1
            lock.notify()
            while (state.x != 1){
                lock.wait()
            }
            println("x: ${state.x}")
        }
    }

    t1.start()
    t2.start()

    t1.join()
    t2.join()
}