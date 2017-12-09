package org.biacode.jleadboxer.model.leadboard

import org.biacode.jleadboxer.model.common.CommonJLeadBoxerResponse

/**
 * Created by Arthur Asatryan.
 * Date: 12/8/17
 * Time: 7:42 PM
 */
data class GetSessionsRequest(val leadId: String, val limit: Int = 50)

class GetSessionsResponse(val sessions: List<Map<Any, Any>>) : CommonJLeadBoxerResponse()