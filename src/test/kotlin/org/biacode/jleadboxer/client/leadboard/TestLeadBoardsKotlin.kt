package org.biacode.jleadboxer.client.leadboard

import com.github.kittinunf.result.Result
import org.biacode.jleadboxer.client.JLeadBoxerClient
import org.biacode.jleadboxer.model.leadboard.GetEventsRequest
import org.biacode.jleadboxer.model.leadboard.GetLeadsRequest
import org.biacode.jleadboxer.model.leadboard.GetSessionsRequest
import org.biacode.jleadboxer.test.AbstractJLeadBoxerUnitTest
import org.biacode.jleadboxer.test.AbstractJLeadBoxerUnitTest.LeadBoxerCredentials
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Created by Arthur Asatryan.
 * Date: 12/8/17
 * Time: 5:16 PM
 */
val logger: Logger = LoggerFactory.getLogger("TestLeadBoardsKotlin")

class TestLeadBoardsKotlin : AbstractJLeadBoxerUnitTest() {

    @Test
    fun testDummy() {
    }

}

fun main(args: Array<String>) {
    getLeads()
    getSessions("1505135787782.1263221347")
    getEvents("1513429739527.1263221347")
}

private fun getLeads() {
    JLeadBoxerClient
            .leadBoard
            .getLeadsAsync(
                    GetLeadsRequest.build(LeadBoxerCredentials.apiKey, LeadBoxerCredentials.datasetId) {},
                    { request, _, result ->
                        logger.info("getLeads cURL - {}", request.cUrlString())
                        when (result) {
                            is Result.Failure -> {
                                logger.error("getLeads - {}", result.error)
                            }
                            is Result.Success -> {
                                logger.info("getLeads - {}", result.value)
                            }
                        }
                    }
            )
}

private fun getSessions(leadId: String) {
    JLeadBoxerClient
            .leadBoard
            .getSessionsAsync(
                    GetSessionsRequest(leadId),
                    { request, _, result ->
                        logger.info("getSessions cURL - {}", request.cUrlString())
                        when (result) {
                            is Result.Failure -> {
                                logger.error("getSessions - {}", result.error)
                            }
                            is Result.Success -> {
                                logger.info("getSessions - {}", result.value)
                            }
                        }
                    }
            )
}

private fun getEvents(sessionId: String) {
    JLeadBoxerClient
            .leadBoard
            .getEventsAsync(
                    GetEventsRequest(sessionId),
                    { request, _, result ->
                        logger.info("getEvents cURL - {}", request.cUrlString())
                        when (result) {
                            is Result.Failure -> {
                                logger.error("getEvents - {}", result.error)
                            }
                            is Result.Success -> {
                                logger.info("getEvents - {}", result.value)
                            }
                        }
                    }
            )
}