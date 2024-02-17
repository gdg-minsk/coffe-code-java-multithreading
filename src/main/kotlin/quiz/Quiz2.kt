package quiz

class Quiz2 {

    /**
     * Is the print statement in the below code reachable?
     */
    fun doubleSynchronization() {
        synchronized(this) {
            synchronized(this) {
                println("Is this line unreachable ?")
            }
        }
    }
}