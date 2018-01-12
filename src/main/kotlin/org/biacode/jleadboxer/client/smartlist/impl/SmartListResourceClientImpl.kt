package org.biacode.jleadboxer.client.smartlist.impl

import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.fuel.gson.responseObject
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result
import org.biacode.jleadboxer.client.helper.ResourceClientHelper
import org.biacode.jleadboxer.client.smartlist.SmartListResourceClient
import org.biacode.jleadboxer.model.smartlist.*

/**
 * Created by Arthur Asatryan.
 * Date: 12/6/17
 * Time: 6:13 PM
 */
class SmartListResourceClientImpl : SmartListResourceClient {

    //region Public methods
    override fun getSmartListsAsync(request: GetSmartListsRequest, handler: (Request, Response, Result<GetSmartListsResponse, FuelError>) -> Unit
    ) = "/smartlists"
            .httpGet(listOf("email" to request.email, "apiKey" to request.apiKey, "accountId" to request.accountId, "datasetId" to request.datasetId))
            .responseObject(handler)

    override fun getSmartListsSync(request: GetSmartListsRequest) = "/smartlists"
            .httpGet(listOf("email" to request.email, "apiKey" to request.apiKey, "accountId" to request.accountId, "datasetId" to request.datasetId))
            .responseObject<GetSmartListsResponse>().third.get()

    override fun createAsync(request: CreateSmartListRequest, handler: (Request, Response, Result<CreateSmartListResponse, FuelError>) -> Unit
    ) = "/smartlists?apiKey=${request.apiKey}&email=${request.email}".httpPost()
            .body(ResourceClientHelper.convertToJson(getCreateSmartListParams(request)))
            .responseObject(handler)

    override fun createSync(request: CreateSmartListRequest) = "/smartlists?apiKey=${request.apiKey}&email=${request.email}".httpPost()
            .body(ResourceClientHelper.convertToJson(getCreateSmartListParams(request)))
            .responseObject<CreateSmartListResponse>().third.get()

    override fun createDefaultSmartListAsync(request: CreateDefaultSmartListRequest, handler: (Request, Response, Result<CreateDefaultSmartListResponse, FuelError>) -> Unit
    ) = "/smartlists/default?apiKey=${request.apiKey}&email=${request.email}".httpPost()
            .body(ResourceClientHelper.convertToJson(mapOf(
                    "accountId" to request.accountId,
                    "datasetId" to request.datasetId
            )))
            .responseObject(handler)

    override fun createDefaultSmartListSync(request: CreateDefaultSmartListRequest) = "/smartlists/default?apiKey=${request.apiKey}&email=${request.email}".httpPost()
            .body(ResourceClientHelper.convertToJson(mapOf(
                    "accountId" to request.accountId,
                    "datasetId" to request.datasetId
            )))
            .responseObject<CreateDefaultSmartListResponse>().third.get()

    override fun updateAsync(request: UpdateSmartListRequest, handler: (Request, Response, Result<UpdateSmartListResponse, FuelError>) -> Unit
    ) = "/smartlists/${request.smartlistId}?apiKey=${request.apiKey}&email=${request.email}".httpPut()
            .body(ResourceClientHelper.convertToJson(getUpdateSmartListParams(request)))
            .responseObject(handler)

    override fun updateSync(request: UpdateSmartListRequest)= "/smartlists/${request.smartlistId}?apiKey=${request.apiKey}&email=${request.email}".httpPut()
            .body(ResourceClientHelper.convertToJson(getUpdateSmartListParams(request)))
            .responseObject<UpdateSmartListResponse>().third.get()

    override fun deleteAsync(request: DeleteSmartListRequest, handler: (Request, Response, Result<DeleteSmartListResponse, FuelError>) -> Unit
    ) = "/smartlists/${request.smartlistId}".httpDelete(listOf(
            "apiKey" to request.apiKey,
            "email" to request.email
    )).responseObject(handler)

    override fun deleteSync(request: DeleteSmartListRequest) = "/smartlists/${request.smartlistId}".httpDelete(listOf(
            "apiKey" to request.apiKey,
            "email" to request.email
    )).responseObject<DeleteSmartListResponse>().third.get()
    //endregion


    //region Companion objects
    companion object {
        fun getCreateSmartListParams(request: CreateSmartListRequest): Map<String, Any?> = mapOf(
                "accountId" to request.accountId,
                "additionalCsvFields" to request.additionalCsvFields,
                "datasetId" to request.datasetId,
                "dayOfWeek" to request.dayOfWeek.day,
                "exitLinkFilter" to request.exitLinkFilter,
                "fieldFilter" to request.fieldFilter,
                "format" to request.format?.format,
                "mailTemplate" to request.mailTemplate,
                "name" to request.name,
                "notificationMailIds" to request.notificationMailIds,
                "notificationType" to request.notificationType,
                "numberFilter" to request.numberFilter,
                "search" to request.search,
                "sortBy" to request.sortBy.sortProperty,
                "sortOrder" to request.sortOrder.order,
                "textFilter" to request.textFilter,
                "timeFilter" to request.timeFilter,
                "type" to request.type
        )

        fun getUpdateSmartListParams(request: UpdateSmartListRequest): Map<String, Any?> = mapOf(
                "accountId" to request.accountId,
                "additionalCsvFields" to request.additionalCsvFields,
                "dayOfWeek" to request.dayOfWeek.day,
                "exitLinkFilter" to request.exitLinkFilter,
                "fieldFilter" to request.fieldFilter,
                "format" to request.format?.format,
                "mailTemplate" to request.mailTemplate,
                "notificationMailIds" to request.notificationMailIds,
                "notificationType" to request.notificationType,
                "numberFilter" to request.numberFilter,
                "search" to request.search,
                "sortBy" to request.sortBy.sortProperty,
                "sortOrder" to request.sortOrder.order,
                "textFilter" to request.textFilter,
                "timeFilter" to request.timeFilter,
                "type" to request.type
        )
    }
    //endregion
}