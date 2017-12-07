package org.biacode.jleadboxer.model.dataset

import java.util.*

/**
 * Created by Arthur Asatryan.
 * Date: 12/6/17
 * Time: 4:01 PM
 */
data class CreateDatasetRequest(
        val apiKey: String,
        val email: String,
        val accountId: String,
        val datasetId: String = UUID.randomUUID().toString(),
        val humanName: String = UUID.randomUUID().toString(),
        val sendEmail: Boolean? = null,
        val timezone: String = "Europe/Amsterdam",
        val userIds: Set<Int>
)

data class CreateDatasetResponse(
        val datasetId: String,
        val responseCode: Int,
        val responseMessage: String
)
