package onim.test.notification

import onim.test.annotation.NoArg

@NoArg
data class UserJoined(
    val id: Int,
    val email: String,
    val duplicated: Boolean,
)
