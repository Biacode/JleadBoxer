package org.biacode.jleadboxer.model.dataset

import org.biacode.jleadboxer.model.common.CommonJLeadBoxerResponse

/**
 * Created by Arthur Asatryan.
 * Date: 12/7/17
 * Time: 5:38 PM
 */
data class DeleteDatasetRequest(
        val datasetId: String,
        val email: String,
        val apiKey: String
)

class DeleteDatasetResponse : CommonJLeadBoxerResponse()