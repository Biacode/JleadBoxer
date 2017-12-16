package org.biacode.jleadboxer.client.leadboard

import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.result.Result
import org.biacode.jleadboxer.model.leadboard.*

/**
 * Created by Arthur Asatryan.
 * Date: 12/6/17
 * Time: 6:11 PM
 */
interface LeadBoardResourceClient {
    fun getLeadsAsync(
            request: GetLeadsRequest,
            handler: (Request, Response, Result<GetLeadsResponse, FuelError>) -> Unit
            = { _, _, _ -> }
    ): Request

    fun getLeadsSync(request: GetLeadsRequest): GetLeadsResponse

    fun getSessionsAsync(
            request: GetSessionsRequest,
            handler: (Request, Response, Result<GetSessionsResponse, FuelError>) -> Unit
            = { _, _, _ -> }
    ): Request

    fun getSessionsSync(request: GetSessionsRequest): GetSessionsResponse

    fun getEventsAsync(
            request: GetEventsRequest,
            handler: (Request, Response, Result<GetEventsResponse, FuelError>) -> Unit
            = { _, _, _ -> }
    ): Request

    fun getEventsSync(request: GetEventsRequest): GetEventsResponse
}