package org.biacode.jleadboxer.client.dataset

import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.result.Result
import org.biacode.jleadboxer.model.dataset.*

/**
 * Created by Arthur Asatryan.
 * Date: 12/6/17
 * Time: 5:44 PM
 */
interface DatasetResourceClient {
    fun create(
            request: CreateDatasetRequest,
            handler: (Request, Response, Result<CreateDatasetResponse, FuelError>) -> Unit
            = { _, _, _ -> }
    ): Request

    fun delete(
            request: DeleteDatasetRequest,
            handler: (Request, Response, Result<DeleteDatasetResponse, FuelError>) -> Unit
            = { _, _, _ -> }
    ): Request

    fun update(
            request: UpdateDatasetRequest,
            handler: (Request, Response, Result<UpdateDatasetResponse, FuelError>) -> Unit
            = { _, _, _ -> }
    ): Request
}