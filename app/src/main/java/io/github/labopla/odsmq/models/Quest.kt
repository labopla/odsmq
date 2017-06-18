package io.github.labopla.odsmq.models

import io.github.labopla.odsmq.enums.Category
import io.github.labopla.odsmq.enums.Status

class Quest {
    data class QuestDetail(val id :Long,
                           val category: Category,
                           val client: User,
                           val limit: Long,
                           val detail: String,
                           val rewards: String,
                           val status: Status)
}