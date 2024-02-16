package synchronized

class ExampleClass {
    companion object {
        private var counter = 0

        @Synchronized
        fun incrementCounter() {
            // Код внутри synchronized блока будет выполнен только одним потоком одновременно
            // synchronized(ExampleClass::class)
            counter++
            println("Counter: $counter")
        }

        fun getCounter(): Int {
            return counter
        }
    }

    fun incrementCounter2() {
        synchronized(ExampleClass::class) {
            counter++
            println("Counter: $counter")
        }
    }
}