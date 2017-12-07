package org.biacode.jleadboxer

import com.github.kittinunf.fuel.gson.responseObject
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getAs
import org.biacode.jleadboxer.client.JLeadBoxerClient
import org.biacode.jleadboxer.client.helper.ResourceClientHelper
import org.biacode.jleadboxer.model.dataset.CreateDatasetRequest
import org.biacode.jleadboxer.model.dataset.CreateDatasetResponse
import org.biacode.jleadboxer.model.dataset.DeleteDatasetRequest
import org.biacode.jleadboxer.test.AbstractJLeadBoxerUnitTest
import org.biacode.jleadboxer.test.AbstractJLeadBoxerUnitTest.LeadBoxerCredentials
import org.biacode.jleadboxer.test.AbstractJLeadBoxerUnitTest.LeadBoxerCredentials.setupFuel
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Created by Arthur Asatryan.
 * Date: 12/4/17
 * Time: 5:51 PM
 */

val logger: Logger = LoggerFactory.getLogger("TestApplication");

class TestKotlinApplication : AbstractJLeadBoxerUnitTest() {

    @Test
    fun testDataset() {
        JLeadBoxerClient.dataset.create(CreateDatasetRequest(
                apiKey = LeadBoxerCredentials.apiKey,
                email = LeadBoxerCredentials.userEmail,
                accountId = LeadBoxerCredentials.accountId,
                timezone = "Europe/Amsterdam",
                userIds = setOf(3839)
        ), { request, response, result ->
            logger.debug("createDataset request - {}", request)
            logger.debug("createDataset response - {}", response)
            logger.debug("createDataset result - {}", result)
            logger.debug("createDataset cURL - {}", request.cUrlString())
            when (result) {
                is Result.Failure -> {
                    val error = result.getAs<String>()
                    logger.error("createDataset - {}", error)
                }
                is Result.Success -> {
                    val data = result.getAs<String>()
                    logger.info("createDataset data - {}", data)
                    val resultMap = ResourceClientHelper.convertToJson(data)
                    logger.info("createDataset map - {}", resultMap)
                }
            }
        })
    }

}

fun main(args: Array<String>) {
    setupFuel()
//    createDataset()
    deleteDataset()
}

private fun deleteDataset() {
    JLeadBoxerClient.dataset.delete(
            DeleteDatasetRequest(
                    "1311394126234eb083a408cdf50f4318",
                    LeadBoxerCredentials.userEmail,
                    LeadBoxerCredentials.apiKey
            ),
            { request, response, result ->
                logger.info("cURL - {}", request.cUrlString())
                when (result) {
                    is Result.Failure -> {
                        logger.error("deleteDataset - {}", result.error)
                    }
                    is Result.Success -> {
                        logger.info("deleteDataset - {}", result.value)
                    }
                }
            }
    )
}

private fun createDataset() {
    val create = JLeadBoxerClient.dataset.create(CreateDatasetRequest(
            apiKey = LeadBoxerCredentials.apiKey,
            email = LeadBoxerCredentials.userEmail,
            accountId = LeadBoxerCredentials.accountId,
            timezone = "Europe/Amsterdam",
            userIds = setOf(3839)
    ), { request, response, result ->
        logger.info("createDataset cURL - {}", request.cUrlString())
        when (result) {
            is Result.Failure -> {
                logger.error("createDataset - {}", result.error)
            }
            is Result.Success -> {
                logger.info("createDataset data - {}", result)
                logger.info("createDataset map - {}", result.value)
            }
        }
    })
    val (a, b, c) = create.responseObject<CreateDatasetResponse>();

}