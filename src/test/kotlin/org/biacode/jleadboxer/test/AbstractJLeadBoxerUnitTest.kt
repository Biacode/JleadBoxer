package org.biacode.jleadboxer.test

import org.easymock.EasyMockRunner
import org.easymock.EasyMockSupport
import org.junit.runner.RunWith

/**
 * Created by Arthur Asatryan.
 * Date: 12/7/17
 * Time: 3:22 PM
 */
@RunWith(EasyMockRunner::class)
abstract class AbstractJLeadBoxerUnitTest : EasyMockSupport() {

    object LeadBoxerCredentials {
        val apiKey = "9b7d5817-8155-46fe-9466-9f543fa5adef"
        val datasetId = "1742698a9bffafd4a17ce9bd8de8a521"
        val accountId = "c1a21bd012fba4e3a72861d874c799f0"
        val userEmail = "info@callmonkey.com"
        val basePath = "https://kibana.leadboxer.com/api"
    }
}