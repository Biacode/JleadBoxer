package org.biacode.jleadboxer.client.leadboard.impl

import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.fuel.gson.responseObject
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import org.biacode.jleadboxer.client.leadboard.LeadBoardResourceClient
import org.biacode.jleadboxer.model.leadboard.*

/**
 * Created by Arthur Asatryan.
 * Date: 12/6/17
 * Time: 6:11 PM
 */
class LeadBoardResourceClientImpl : LeadBoardResourceClient {

    //region Public methods
    override fun getLeadsAsync(
            request: GetLeadsRequest,
            handler: (Request, Response, Result<GetLeadsResponse, FuelError>) -> Unit
    ) = "/views/c_view_leads"
            .httpGet(getLeadsParams(request))
            .responseObject(handler)

    override fun getLeadsSync(request: GetLeadsRequest) = "/views/c_view_leads"
            .httpGet(getLeadsParams(request))
            .responseObject<GetLeadsResponse>().third.get()

    override fun getSessionsAsync(
            request: GetSessionsRequest,
            handler: (Request, Response, Result<GetSessionsResponse, FuelError>) -> Unit
    ) = "/leads/sessions"
            .httpGet(listOf("leadId" to request.leadId, "limit" to request.limit))
            .responseObject(handler)

    override fun getSessionsSync(request: GetSessionsRequest) = "/leads/sessions"
            .httpGet(listOf("leadId" to request.leadId, "limit" to request.limit))
            .responseObject<GetSessionsResponse>().third.get()

    override fun getEventsAsync(
            request: GetEventsRequest,
            handler: (Request, Response, Result<GetEventsResponse, FuelError>) -> Unit
    ) = "/leads/events"
            .httpGet(listOf("sessionId" to request.sessionId, "limit" to request.limit))
            .responseObject(handler)

    override fun getEventsSync(request: GetEventsRequest) = "/leads/events"
            .httpGet(listOf("sessionId" to request.sessionId, "limit" to request.limit))
            .responseObject<GetEventsResponse>().third.get()
    //endregion

    //region Companion objects
    companion object {
        fun getLeadsParams(request: GetLeadsRequest): List<Pair<String, Any?>> = listOf(
                "apiKey" to request.apiKey,
                "site" to request.site,
                "search" to request.search,
                "limit" to request.limit,
                "locale" to request.locale,
                "nextToken" to request.nextToken,
                "criteriaTextFilter" to request.criteriaTextFilter,
                "criteriaNumberFilter" to request.criteriaNumberFilter,
                "criteriaTimeFilter" to request.criteriaTimeFilter,
                "criteriaFieldFilter" to request.criteriaFieldFilter,
                "criteriaExitLinkFilter" to request.criteriaExitLinkFilter,
                "usePresetExclusionList" to request.usePresetExclusionList,
                "usePresetInclusionList" to request.usePresetInclusionList,
                "showColumns" to request.showColumns,
                "email" to request.email,
                "login" to request.login,
                "period" to request.period,
                "noShortenEmail" to request.noShortenEmail,
                "date" to request.date,
                "unixTime" to request.unixTime,
                "sortBy" to request.sortBy,
                "showLeadList" to request.showLeadList,
                "showAllLeadsFor" to request.showAllLeadsFor,
                "dataType" to request.dataType,
                "col" to request.col,
                "hideColumns" to request.hideColumns,
                "variant" to request.variant,
                "ignoreLocale" to request.ignoreLocale,
                "dateFormat" to request.dateFormat
        )
    }
    //endregion
}