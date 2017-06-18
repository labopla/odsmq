package io.github.labopla.odsmq.models

class User {
    data class UserDetail(val id: Long,
                          val name: String,
                          val email: String)
}