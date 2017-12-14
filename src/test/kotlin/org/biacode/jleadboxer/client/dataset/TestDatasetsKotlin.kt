package org.biacode.jleadboxer.client.dataset

import com.github.kittinunf.fuel.gson.responseObject
import com.github.kittinunf.result.Result
import org.biacode.jleadboxer.client.JLeadBoxerClient
import org.biacode.jleadboxer.model.dataset.*
import org.biacode.jleadboxer.test.AbstractJLeadBoxerUnitTest
import org.biacode.jleadboxer.test.AbstractJLeadBoxerUnitTest.LeadBoxerCredentials
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

/**
 * Created by Arthur Asatryan.
 * Date: 12/4/17
 * Time: 5:51 PM
 */

val logger: Logger = LoggerFactory.getLogger("TestApplication")

class TestKotlinApplication : AbstractJLeadBoxerUnitTest() {

    @Test
    fun testDummy() {
    }

}

fun main(args: Array<String>) {
    val datasetId = createDatasetSync()
    updateDataset(datasetId)
    deleteDataset(datasetId)
}

private fun createDatasetAsync() {
    JLeadBoxerClient.dataset.createAsync(CreateDatasetRequest(
            apiKey = LeadBoxerCredentials.apiKey,
            email = LeadBoxerCredentials.userEmail
    ), { request, _, result ->
        logger.info("createDatasetAsync cURL - {}", request.cUrlString())
        when (result) {
            is Result.Failure -> {
                logger.error("createDatasetAsync - {}", result.error)
            }
            is Result.Success -> {
                logger.info("createDatasetAsync data - {}", result)
                logger.info("createDatasetAsync map - {}", result.value)
            }
        }
    })
}

private fun createDatasetSync(): String {
    return JLeadBoxerClient.dataset
            .createAsync(CreateDatasetRequest(apiKey = LeadBoxerCredentials.apiKey, email = LeadBoxerCredentials.userEmail))
            .responseObject<CreateDatasetResponse>().third.get().datasetId
}

private fun updateDataset(datasetId: String): String {
    return JLeadBoxerClient.dataset.updateAsync(
            UpdateDatasetRequest(
                    "updated human name ${UUID.randomUUID()}",
                    datasetId,
                    LeadBoxerCredentials.userEmail,
                    LeadBoxerCredentials.apiKey
            ),
            { request, _, result ->
                logger.info("updateDataset cURL - {}", request.cUrlString())
                when (result) {
                    is Result.Failure -> {
                        logger.error("updateDataset - {}", result.error)
                    }
                    is Result.Success -> {
                        logger.info("updateDataset - {}", result.value)
                    }
                }
            }
    ).responseObject<UpdateDatasetResponse>().third.get().responseMessage
}

private fun deleteDataset(datasetId: String): String {
    return JLeadBoxerClient.dataset.deleteAsync(
            DeleteDatasetRequest(
                    datasetId,
                    LeadBoxerCredentials.userEmail,
                    LeadBoxerCredentials.apiKey
            ),
            { request, _, result ->
                logger.info("deleteDataset cURL - {}", request.cUrlString())
                when (result) {
                    is Result.Failure -> {
                        logger.error("deleteDataset - {}", result.error)
                    }
                    is Result.Success -> {
                        logger.info("deleteDataset - {}", result.value)
                    }
                }
            }
    ).responseObject<DeleteDatasetResponse>().third.get().responseMessage
}
