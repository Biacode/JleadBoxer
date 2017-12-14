package org.biacode.jleadboxer.test

import org.easymock.EasyMockRunner
import org.easymock.EasyMockSupport
import org.junit.runner.RunWith
import java.util.*

/**
 * Created by Arthur Asatryan.
 * Date: 12/7/17
 * Time: 3:22 PM
 */
@RunWith(EasyMockRunner::class)
abstract class AbstractJLeadBoxerUnitTest : EasyMockSupport() {

    object LeadBoxerCredentials {
        val apiKey = UUID.randomUUID().toString()
        val datasetId = UUID.randomUUID().toString()
        val accountId = UUID.randomUUID().toString()
        val userEmail = UUID.randomUUID().toString()
        val basePath = "https://kibana.leadboxer.com/api"
    }
}