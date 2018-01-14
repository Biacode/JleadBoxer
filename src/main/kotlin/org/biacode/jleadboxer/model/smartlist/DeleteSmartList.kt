package org.biacode.jleadboxer.model.smartlist

import org.biacode.jleadboxer.model.common.CommonJLeadBoxerResponse

/**
 * User: Syuzanna Eprikyan
 * Date: 1/10/18
 * Time: 5:11 PM
 */

data class DeleteSmartListRequest(
        val apiKey: String,
        val email: String,
        val smartlistId: String
)

data class DeleteSmartListResponse(
        val datasetId: String
) : CommonJLeadBoxerResponse()