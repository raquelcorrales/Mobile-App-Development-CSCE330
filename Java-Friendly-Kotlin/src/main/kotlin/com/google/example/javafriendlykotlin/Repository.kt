object Repository {
    const val BACKUP_PATH = "/backup/user.repo"

    private val _users = mutableListOf<User>()
    private var _nextGuestId = 1000

    @JvmStatic
    val users: List<User>
        get() = _users

    @JvmStatic
    val nextGuestId
        get() = _nextGuestId++

    init {
        _users.add(User(100, "josh", "Joshua Calvert", listOf("admin", "staff", "sys")))
        _users.add(User(101, "dahybi", "Dahybi Yadev", listOf("staff", "nodes")))
        _users.add(User(102, "sarha", "Sarha Mitcham", listOf("admin", "staff", "sys")))
        _users.add(User(103, "warlow", groups = listOf("staff", "inactive")))
    }

    @JvmStatic
    @Throws(IOException::class)
    fun saveAs(path: String?):Boolean {
        val backupPath = path ?: return false

        val outputFile = File(backupPath)
        if (!outputFile.canWrite()) {
            throw FileNotFoundException("Could not write to file: $backupPath")
        }
        // Write data...
        return true
    }

    @JvmStatic
    fun addUser(user: User) {
        // Ensure the user isn't already in the collection.
        val existingUser = users.find { user.id == it.id }
        existingUser?.let { _users.remove(it) }
        // Add the user.
        _users.add(user)
    }
}