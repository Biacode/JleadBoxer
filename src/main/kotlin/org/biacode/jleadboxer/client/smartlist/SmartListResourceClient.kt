package org.biacode.jleadboxer.client.smartlist

import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.result.Result
import org.biacode.jleadboxer.model.smartlist.*

/**
 * Created by Arthur Asatryan.
 * Date: 12/6/17
 * Time: 6:12 PM
 */
interface SmartListResourceClient {
    fun getSmartListsAsync(
            request: GetSmartListsRequest,
            handler: (Request, Response, Result<GetSmartListsResponse, FuelError>) -> Unit
            = { _, _, _ -> }
    ): Request

    fun getSmartListsSync(request: GetSmartListsRequest): GetSmartListsResponse

    fun createAsync(
            request: CreateSmartListRequest,
            handler: (Request, Response, Result<CreateSmartListResponse, FuelError>) -> Unit
            = { _, _, _ -> }
    ): Request

    fun createSync(request: CreateSmartListRequest): CreateSmartListResponse

    fun createDefaultSmartListAsync(
            request: CreateDefaultSmartListRequest,
            handler: (Request, Response, Result<CreateDefaultSmartListResponse, FuelError>) -> Unit
            = { _, _, _ -> }
    ): Request

    fun createDefaultSmartListSync(request: CreateDefaultSmartListRequest): CreateDefaultSmartListResponse

    fun updateAsync(
            request: UpdateSmartListRequest,
            handler: (Request, Response, Result<UpdateSmartListResponse, FuelError>) -> Unit
            = { _, _, _ -> }
    ): Request

    fun updateSync(request: UpdateSmartListRequest): UpdateSmartListResponse

    fun deleteAsync(
            request: DeleteSmartListRequest,
            handler: (Request, Response, Result<DeleteSmartListResponse, FuelError>) -> Unit
            = { _, _, _ -> }
    ): Request

    fun deleteSync(request: DeleteSmartListRequest): DeleteSmartListResponse
}