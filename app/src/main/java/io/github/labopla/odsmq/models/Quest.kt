package io.github.labopla.odsmq.models

import io.github.labopla.odsmq.enums.Category
import io.github.labopla.odsmq.enums.Status

data class Quest(var id: Long,
                 var category: Category,
                 var client: User,
                 var limit: Long,
                 var detail: String,
                 var rewards: String,
                 var status: Status)