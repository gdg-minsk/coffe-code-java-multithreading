package quiz.solution

import java.util.concurrent.Executors
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

class SolutionQuizBlockingQueueWithMutex<T>(
    private val capacity: Int
) {

    @Suppress("UNCHECKED_CAST")
    private val array: Array<T?> = arrayOfNulls<Any>(capacity) as Array<T?>
    private val lock: Lock = ReentrantLock()
    private var size: Int = 0
    private var head: Int = 0
    private var tail: Int = 0

    fun dequeue(): T? {
        lock.lock()
        while (size == 0) {
            lock.unlock()
            lock.lock()
        }

        if (head == capacity) {
            head = 0
        }

        val item: T? = array[head]
        array[head] = null
        head++
        size--

        lock.unlock()
        return item
    }

    fun enqueue(item: T) {
        lock.lock()
        while (size == capacity) {
            // Release the mutex to give other threads
            lock.unlock()
            // Reacquire the mutex before checking the
            // condition
            lock.lock()
        }

        if (tail == capacity) {
            tail = 0
        }

        array[tail] = item
        size++
        tail++
        lock.unlock()
    }
}