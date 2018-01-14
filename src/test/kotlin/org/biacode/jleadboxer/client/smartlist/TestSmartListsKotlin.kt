package org.biacode.jleadboxer.client.smartlist

import com.github.kittinunf.result.Result
import org.biacode.jleadboxer.client.JLeadBoxerClient
import org.biacode.jleadboxer.model.smartlist.*
import org.biacode.jleadboxer.test.AbstractJLeadBoxerUnitTest
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * User: Syuzanna Eprikyan
 * Date: 1/11/18
 * Time: 5:50 PM
 */
val logger: Logger = LoggerFactory.getLogger("TestSmartListsKotlin")

class TestSmartListsKotlin : AbstractJLeadBoxerUnitTest() {

    @Test
    fun testDummy() {
    }

}

fun main(args: Array<String>) {
    getSmartLists()
    //  updateSmartList()
    //   createSmartList()
//    deleteSmartList()
}

private fun getSmartLists() {
    JLeadBoxerClient
            .smartList
            .getSmartListsAsync(
                    GetSmartListsRequest(AbstractJLeadBoxerUnitTest.LeadBoxerCredentials.apiKey, AbstractJLeadBoxerUnitTest.LeadBoxerCredentials.accountId, AbstractJLeadBoxerUnitTest.LeadBoxerCredentials.userEmail, "17f79b7784354d489deaf1219c390b41"),
                    { request, _, result ->
                        logger.info("getSmartLists cURL - {}", request.cUrlString())
                        when (result) {
                            is Result.Failure -> {
                                logger.error("getSmartLists - {}", result.error)
                            }
                            is Result.Success -> {
                                logger.info("getSmartLists - {}", result.value)
                            }
                        }
                    }
            )
}

private fun createSmartList() {
    JLeadBoxerClient
            .smartList
            .createAsync(
                    CreateSmartListRequest.build(AbstractJLeadBoxerUnitTest.LeadBoxerCredentials.apiKey,
                            AbstractJLeadBoxerUnitTest.LeadBoxerCredentials.userEmail,
                            AbstractJLeadBoxerUnitTest.LeadBoxerCredentials.accountId,
                            "17f79b7784354d489deaf1219c390b41",
                            "Test smart list",
                            SmartListType.USER) { dayOfWeek = DayOfWeek.SUNDAY },
                    { request, _, result ->
                        logger.info("getSmartLists cURL - {}", request.cUrlString())
                        when (result) {
                            is Result.Failure -> {
                                logger.error("getSmartLists - {}", result.error)
                            }
                            is Result.Success -> {
                                logger.info("getSmartLists - {}", result.value)
                            }
                        }
                    }
            )
}

private fun updateSmartList() {
    JLeadBoxerClient
            .smartList
            .updateAsync(
                    UpdateSmartListRequest(AbstractJLeadBoxerUnitTest.LeadBoxerCredentials.apiKey,
                            AbstractJLeadBoxerUnitTest.LeadBoxerCredentials.userEmail,
                            AbstractJLeadBoxerUnitTest.LeadBoxerCredentials.accountId,
                            "14118",
                            dayOfWeek = DayOfWeek.TUESDAY),
                    { request, _, result ->
                        logger.info("getSmartLists cURL - {}", request.cUrlString())
                        when (result) {
                            is Result.Failure -> {
                                logger.error("getSmartLists - {}", result.error)
                            }
                            is Result.Success -> {
                                logger.info("getSmartLists - {}", result.value)
                            }
                        }
                    }
            )
}

private fun deleteSmartList() {
    JLeadBoxerClient
            .smartList
            .deleteAsync(
                    DeleteSmartListRequest(AbstractJLeadBoxerUnitTest.LeadBoxerCredentials.apiKey,
                            AbstractJLeadBoxerUnitTest.LeadBoxerCredentials.userEmail,
                            "14119"),
                    { request, _, result ->
                        logger.info("getSmartLists cURL - {}", request.cUrlString())
                        when (result) {
                            is Result.Failure -> {
                                logger.error("getSmartLists - {}", result.error)
                            }
                            is Result.Success -> {
                                logger.info("getSmartLists - {}", result.value)
                            }
                        }
                    }
            )
}