package org.biacode.jleadboxer.model.dataset

import org.biacode.jleadboxer.model.common.CommonJLeadBoxerResponse

/**
 * Created by Arthur Asatryan.
 * Date: 12/8/17
 * Time: 12:28 PM
 */
data class UpdateDatasetRequest(
        val humanName: String,
        val datasetId: String,
        val email: String,
        val apiKey: String
)

class UpdateDatasetResponse : CommonJLeadBoxerResponse()