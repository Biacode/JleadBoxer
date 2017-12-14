package org.biacode.jleadboxer.client.dataset.impl

import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.fuel.gson.responseObject
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result
import org.biacode.jleadboxer.client.dataset.DatasetResourceClient
import org.biacode.jleadboxer.client.helper.ResourceClientHelper.convertToJson
import org.biacode.jleadboxer.model.dataset.*

/**
 * Created by Arthur Asatryan.
 * Date: 12/6/17
 * Time: 5:42 PM
 */
class DatasetResourceClientImpl : DatasetResourceClient {

    //region Public methods
    override fun createAsync(
            request: CreateDatasetRequest,
            handler: (Request, Response, Result<CreateDatasetResponse, FuelError>) -> Unit
    ) = "/datasets?apiKey=${request.apiKey}&email=${request.email}".httpPost()
            .body(convertToJson(mapOf(
                    "humanName" to request.humanName,
                    "sendEmail" to request.sendEmail,
                    "timezone" to request.timezone,
                    "userIds" to request.userIds
            )))
            .responseObject(handler)

    override fun createSync(request: CreateDatasetRequest) = "/datasets?apiKey=${request.apiKey}&email=${request.email}".httpPost()
            .body(convertToJson(mapOf(
                    "humanName" to request.humanName,
                    "sendEmail" to request.sendEmail,
                    "timezone" to request.timezone,
                    "userIds" to request.userIds
            )))
            .responseObject<CreateDatasetResponse>().third.get()

    override fun updateAsync(
            request: UpdateDatasetRequest,
            handler: (Request, Response, Result<UpdateDatasetResponse, FuelError>) -> Unit
    ) = "/datasets/${request.datasetId}/name?humanName=${request.humanName}&email=${request.email}&apiKey=${request.apiKey}"
            .httpPut()
            .responseObject(handler)

    override fun updateSync(request: UpdateDatasetRequest) = "/datasets/${request.datasetId}/name?humanName=${request.humanName}&email=${request.email}&apiKey=${request.apiKey}"
            .httpPut()
            .responseObject<UpdateDatasetResponse>().third.get()

    override fun deleteAsync(
            request: DeleteDatasetRequest,
            handler: (Request, Response, Result<DeleteDatasetResponse, FuelError>) -> Unit
    ) = "/datasets/${request.datasetId}".httpDelete(listOf(
            "apiKey" to request.apiKey,
            "email" to request.email
    )).responseObject(handler)

    override fun deleteSync(request: DeleteDatasetRequest) = "/datasets/${request.datasetId}".httpDelete(listOf(
            "apiKey" to request.apiKey,
            "email" to request.email
    )).responseObject<DeleteDatasetResponse>().third.get()
    //endregion
}