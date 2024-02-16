package synchronized

class EmployeeSynchronized {
    // shared variable
    private var name: String? = null
    private val lock = Any()

    // method is synchronize on 'this' object
    @Synchronized
    fun setName(name: String?) {
        this.name = name
    }

    @Synchronized
    fun resetName(name: String?) {
        synchronized(this) {
            this.name = name
        }
    }

    fun changeName() {
        synchronized(EmployeeSynchronized::class) {
            this.name = name
        }
    }

    // equivalent of adding synchronized in method
    // definition
    fun getName(): String? {
        // Using a different object to synchronize on
        synchronized(lock) {
            return this.name
        }
    }
}