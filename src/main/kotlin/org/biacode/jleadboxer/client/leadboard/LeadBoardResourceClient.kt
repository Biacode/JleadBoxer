package org.biacode.jleadboxer.client.leadboard

import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.result.Result
import org.biacode.jleadboxer.model.leadboard.GetLeadsRequest
import org.biacode.jleadboxer.model.leadboard.GetLeadsResponse
import org.biacode.jleadboxer.model.leadboard.GetSessionsRequest
import org.biacode.jleadboxer.model.leadboard.GetSessionsResponse

/**
 * Created by Arthur Asatryan.
 * Date: 12/6/17
 * Time: 6:11 PM
 */
interface LeadBoardResourceClient {
    fun getLeads(
            request: GetLeadsRequest,
            handler: (Request, Response, Result<GetLeadsResponse, FuelError>) -> Unit
            = { _, _, _ -> }
    ): Request

    fun getSessions(
            request: GetSessionsRequest,
            handler: (Request, Response, Result<GetSessionsResponse, FuelError>) -> Unit
            = { _, _, _ -> }
    ): Request
}