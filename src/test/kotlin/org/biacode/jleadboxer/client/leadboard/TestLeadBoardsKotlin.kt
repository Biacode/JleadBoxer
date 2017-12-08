package org.biacode.jleadboxer.client.leadboard

import com.github.kittinunf.result.Result
import org.biacode.jleadboxer.client.JLeadBoxerClient
import org.biacode.jleadboxer.model.leadboard.GetLeadsRequest
import org.biacode.jleadboxer.test.AbstractJLeadBoxerUnitTest
import org.biacode.jleadboxer.test.AbstractJLeadBoxerUnitTest.LeadBoxerCredentials
import org.biacode.jleadboxer.test.AbstractJLeadBoxerUnitTest.LeadBoxerCredentials.setupFuel
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
    setupFuel()
    JLeadBoxerClient
            .leadBoard
            .getLeads(
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