package org.biacode.jleadboxer.client.dataset.impl

import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import org.biacode.jleadboxer.client.dataset.DatasetResourceClient
import org.biacode.jleadboxer.client.helper.ResourceClientHelper
import org.biacode.jleadboxer.model.dataset.CreateDatasetRequest
import org.biacode.jleadboxer.model.dataset.CreateDatasetResponse

/**
 * Created by Arthur Asatryan.
 * Date: 12/6/17
 * Time: 5:42 PM
 */
class DatasetResourceClientImpl : DatasetResourceClient {

    //region Public methods
    override fun createDataset(request: CreateDatasetRequest,
                               handler: (Request, Response, Result<CreateDatasetResponse, FuelError>) -> Unit,
                               deserializer: ResponseDeserializable<CreateDatasetResponse>): Request {
        return performCreateDataset(request, handler, deserializer)
    }

    override fun createDataset(request: CreateDatasetRequest, handler: (Request, Response, Result<CreateDatasetResponse, FuelError>) -> Unit): Request {
        return performCreateDataset(request, handler, ResourceClientHelper.JacksonFuelDeserializer())
    }
    //endregion

    //region Utility methods
    private fun performCreateDataset(request: CreateDatasetRequest,
                                     handler: (Request, Response, Result<CreateDatasetResponse, FuelError>) -> Unit,
                                     deserializer: ResponseDeserializable<CreateDatasetResponse>
    ): Request = "/datasets?apiKey=${request.apiKey}&email=${request.email}"
            .httpPost()
            .body(ResourceClientHelper.convertToJson(mapOf("dataset" to mapOf(
                    "accountId" to request.accountId,
                    "datasetId" to request.datasetId,
                    "humanName" to request.humanName,
                    "sendEmail" to request.sendEmail,
                    "timezone" to request.timezone,
                    "userIds" to request.userIds
            ))))
            .responseObject(deserializer, handler)
    //endregion
}