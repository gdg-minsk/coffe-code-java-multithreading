package quiz

/**
 * A blocking queue is defined as a queue which blocks the caller of the enqueue method
 * if there's no more capacity to add the new item being enqueued.
 * Similarly, the queue blocks the dequeue caller if there are no items in the queue.
 * Also, the queue notifies a blocked enqueuing thread when space becomes available
 * and a blocked dequeuing thread when an item becomes available in the queue.
 */
class QuizBlockingQueueWithMutex<T>(
    initialCapacity: Int
) {

    @Suppress("UNCHECKED_CAST")
    private val array: Array<T?> = arrayOfNulls<Any?>(initialCapacity) as Array<T?>
    private var size: Int = 0
    private var head: Int = 0
    private var tail: Int = 0

    fun enqueue(item: T) {
    }

    fun dequeue(): T {
        TODO()
    }
}