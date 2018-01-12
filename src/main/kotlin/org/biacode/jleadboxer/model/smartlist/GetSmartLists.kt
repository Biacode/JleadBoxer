package org.biacode.jleadboxer.model.smartlist

import org.biacode.jleadboxer.model.common.CommonJLeadBoxerResponse

/**
 * User: Syuzanna Eprikyan
 * Date: 1/10/18
 * Time: 5:29 PM
 */
data class GetSmartListsRequest(
        val apiKey: String,
        val accountId: String,
        val email: String,
        val datasetId: String
)

data class GetSmartListsResponse(
        val smartlists: List<SmartList>? = null
) : CommonJLeadBoxerResponse()
