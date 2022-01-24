data class User @JvmOverloads constructor(
    @JvmField val id: Int,
    @JvmField val username: String,
    @JvmField val displayName: String = username.toTitleCase(),
    @JvmField val groups: List<String> = listOf("guest")
) {
    val hasSystemAccess
        @JvmName("hasSystemAccess")
        get() = "sys" in groups
}