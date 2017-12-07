package org.biacode.jleadboxer.test

import com.github.kittinunf.fuel.core.FuelManager
import org.biacode.jleadboxer.test.AbstractJLeadBoxerUnitTest.LeadBoxerCredentials.setupFuel
import org.easymock.EasyMockRunner
import org.easymock.EasyMockSupport
import org.junit.Before
import org.junit.runner.RunWith
import java.util.*
import javax.ws.rs.core.HttpHeaders
import javax.ws.rs.core.MediaType

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

        fun setupFuel() {
            FuelManager.instance.basePath = LeadBoxerCredentials.basePath
            FuelManager.instance.baseHeaders = mapOf(HttpHeaders.CONTENT_TYPE to MediaType.APPLICATION_JSON)
        }
    }

    @Before
    fun before() {
        setupFuel()
    }
}