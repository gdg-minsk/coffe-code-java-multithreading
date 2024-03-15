package quiz.solution

import java.util.concurrent.atomic.AtomicInteger

internal class SolutionAtomicBank(initialBalance: Int) {

    private val balance: AtomicInteger = AtomicInteger(initialBalance)

    fun deposit(amount: Int) {
        balance.getAndAdd(amount)
    }

    fun withdraw(amount: Int) {
        var currentBalance: Int
        do {
            currentBalance = balance.get()
        } while (!balance.compareAndSet(currentBalance, currentBalance - amount))
    }

    fun getBalance(): Int {
        return balance.get()
    }
}