package executor

import java.util.concurrent.LinkedBlockingDeque
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy
import java.util.concurrent.TimeUnit

fun main() {
    val threadPoolExecutor = ThreadPoolExecutor(
        1, 5, 1,
        TimeUnit.MINUTES, LinkedBlockingDeque(3), AbortPolicy()
    )

    try {
        // submit six tasks
        for (i in 0..5) {
            threadPoolExecutor.submit {
                println("This is worker thread " + Thread.currentThread().name + " executing")
                try {
                    // simulate work by sleeping for 1 second
                    Thread.sleep(1000L)
                } catch (ignored: InterruptedException) {
                    // ignore for now
                }
            }
        }
    } finally {
        threadPoolExecutor.shutdown()
    }
}