package org.biacode.jleadboxer.model.leadboard

import org.biacode.jleadboxer.model.common.CommonJLeadBoxerResponse

/**
 * Created by Arthur Asatryan.
 * Date: 12/16/17
 * Time: 5:10 PM
 */
data class GetEventsRequest(val sessionId: String, val limit: Int = 50)

data class GetEventsResponse(val events: List<Map<String, Any>>) : CommonJLeadBoxerResponse()