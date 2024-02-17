package quiz

/**
 * Consider the below class which has a synchronized method.
 * Can you tell what object does the thread invoking the addName() method synchronize on?
 */
class Quiz3 {

    private val contacts = mutableListOf<String>()

    @Synchronized
    fun addName(name: String) {
        contacts.add(name)
    }
}