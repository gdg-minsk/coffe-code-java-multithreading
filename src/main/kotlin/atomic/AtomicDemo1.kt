package atomic

import java.util.concurrent.atomic.AtomicInteger

fun main() {
    val total = AtomicInteger(0)
    val expected = 0
    val update = 10

    val result: Boolean = total.compareAndSet(expected, update)
}