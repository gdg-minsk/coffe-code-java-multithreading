package waitnotify

class ProducerConsumerProblem {

    private val obj = Object()
    private var workToDo = false
    fun consume() {
        synchronized(obj) {
            while (!workToDo) {
                obj.wait()
            }

            // get next item from the queue
            workToDo = false
        }
        //do work on the item
    }

    fun produce() {
        synchronized(obj) {
            if (!workToDo) {
                //add work to queue
                workToDo = true
            }

            obj.notifyAll()
        }
    }
}