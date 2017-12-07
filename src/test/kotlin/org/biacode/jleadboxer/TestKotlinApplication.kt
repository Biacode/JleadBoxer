package org.biacode.jleadboxer

import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getAs
import org.biacode.jleadboxer.LeadBoxerConf.setupFuel
import org.biacode.jleadboxer.client.JLeadBoxerClient
import org.biacode.jleadboxer.client.helper.ResourceClientHelper
import org.biacode.jleadboxer.model.dataset.CreateDatasetRequest
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*
import javax.ws.rs.core.HttpHeaders
import javax.ws.rs.core.MediaType

/**
 * Created by Arthur Asatryan.
 * Date: 12/4/17
 * Time: 5:51 PM
 */
val logger: Logger = LoggerFactory.getLogger("TestApplication");

object LeadBoxerConf {
    val apiKey = UUID.randomUUID().toString()
    val datasetId = UUID.randomUUID().toString()
    val accountId = UUID.randomUUID().toString()
    val userEmail = UUID.randomUUID().toString()
    val basePath = "https://kibana.leadboxer.com/api"

    fun setupFuel() {
        FuelManager.instance.basePath = LeadBoxerConf.basePath
        FuelManager.instance.baseHeaders = mapOf(HttpHeaders.CONTENT_TYPE to MediaType.APPLICATION_JSON)
    }
}

class TestKotlinApplication {

    @Test
    fun testDataset() {
        setupFuel()
        JLeadBoxerClient.dataset.createDataset(CreateDatasetRequest(
                apiKey = LeadBoxerConf.apiKey,
                email = LeadBoxerConf.userEmail,
                accountId = LeadBoxerConf.accountId,
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
                    val resultMap = ResourceClientHelper.convertToMap(data)
                    logger.info("createDataset map - {}", resultMap)
                }
            }
        })
    }

}

fun main(args: Array<String>) {
    setupFuel()
    JLeadBoxerClient.dataset.createDataset(CreateDatasetRequest(
            apiKey = LeadBoxerConf.apiKey,
            email = LeadBoxerConf.userEmail,
            accountId = LeadBoxerConf.accountId,
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
                val resultMap = ResourceClientHelper.convertToMap(data)
                logger.info("createDataset map - {}", resultMap)
            }
        }
    })
}