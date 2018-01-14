package org.biacode.jleadboxer.model.smartlist

import org.biacode.jleadboxer.model.common.CommonJLeadBoxerResponse

/**
 * User: Syuzanna Eprikyan
 * Date: 1/10/18
 * Time: 5:11 PM
 */
data class CreateDefaultSmartListRequest(
        val apiKey: String,
        val email: String,
        val accountId: String,
        val datasetId: String
)

data class CreateDefaultSmartListResponse(
        val datasetId: String
) : CommonJLeadBoxerResponse()