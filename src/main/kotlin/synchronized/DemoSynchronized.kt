package synchronized

class Employee {
    // shared variable
    private var name: String? = null

    // also synchronized on the same object
    fun resetName() {
        synchronized(this) {
            this.name = ""
        }
    }

    // method is synchronize on 'this' object
    @Synchronized
    fun setName(name: String?) {
        this.name = name
    }
}