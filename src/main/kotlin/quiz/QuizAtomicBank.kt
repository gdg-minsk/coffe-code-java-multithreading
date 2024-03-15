package quiz

class QuizAtomicBank(
    private var balance: Int
) {
    fun deposit(amount: Int) {
        balance += amount
    }

    fun withdraw(amount: Int) {
        if (balance >= amount) {
            balance -= amount
        } else {
            println("Not enough balance")
        }
    }
}