package org.biacode.jleadboxer.client.dataset.impl

import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result
import org.biacode.jleadboxer.client.dataset.DatasetResourceClient
import org.biacode.jleadboxer.client.helper.ResourceClientHelper
import org.biacode.jleadboxer.model.dataset.CreateDatasetModel

/**
 * Created by Arthur Asatryan.
 * Date: 12/6/17
 * Time: 5:42 PM
 */
class DatasetResourceClientImpl : DatasetResourceClient {
    override fun createDataset(
            model: CreateDatasetModel,
            handler: (Request, Response, Result<String, FuelError>) -> Unit
    ) = "/datasets?apiKey=${model.apiKey}&email=${model.email}"
            .httpPost()
            .body(ResourceClientHelper.toJson(mapOf("dataset" to mapOf(
                    "accountId" to model.accountId,
                    "datasetId" to model.datasetId,
                    "humanName" to model.humanName,
                    "sendEmail" to model.sendEmail,
                    "timezone" to model.timezone,
                    "userIds" to model.userIds
            ))))
            .responseString(handler = handler)
}