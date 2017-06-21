package io.github.labopla.odsmq.models

import io.github.labopla.odsmq.enums.Category
import io.github.labopla.odsmq.enums.Status

data class Quest(
        val id: Long,
        val category: Category,
        val client: User,
        val limit: Long,
        val detail: String,
        val rewards: String,
        val status: Status
)