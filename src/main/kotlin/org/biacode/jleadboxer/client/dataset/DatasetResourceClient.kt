package org.biacode.jleadboxer.client.dataset

import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.result.Result
import org.biacode.jleadboxer.model.dataset.CreateDatasetRequest
import org.biacode.jleadboxer.model.dataset.CreateDatasetResponse

/**
 * Created by Arthur Asatryan.
 * Date: 12/6/17
 * Time: 5:44 PM
 */
interface DatasetResourceClient {
    fun createDataset(
            request: CreateDatasetRequest,
            handler: (Request, Response, Result<CreateDatasetResponse, FuelError>) -> Unit
    ): Request
}