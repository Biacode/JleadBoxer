package org.biacode.jleadboxer.client.leadboard;

import org.biacode.jleadboxer.client.JLeadBoxerClient;
import org.biacode.jleadboxer.client.helper.ResourceClientHelper;
import org.biacode.jleadboxer.model.leadboard.GetLeadsRequest;
import org.biacode.jleadboxer.model.leadboard.GetLeadsResponse;
import org.biacode.jleadboxer.test.AbstractJLeadBoxerUnitTest;
import org.junit.Test;

import static org.biacode.jleadboxer.test.AbstractJLeadBoxerUnitTest.LeadBoxerCredentials;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Arthur Asatryan.
 * Date: 12/13/17
 * Time: 11:59 AM
 */
public class TestLeadBoardsJava extends AbstractJLeadBoxerUnitTest {

    @Test
    public void dummyTest() {
    }
}

class TestCases {
    public static void main(String[] args) {
        LeadBoxerCredentials.INSTANCE.setupFuel();
        final GetLeadsResponse getLeadsResponse = JLeadBoxerClient.INSTANCE.getLeadBoard()
                .getLeads(
                        new GetLeadsRequest.Builder(LeadBoxerCredentials.INSTANCE.getApiKey(), LeadBoxerCredentials.INSTANCE.getDatasetId()).build(),
                        ResourceClientHelper.INSTANCE.ignoreHandling()
                )
                .responseObject(ResourceClientHelper.INSTANCE.deserializer(GetLeadsResponse.class))
                .getThird()
                .get();
        assertNotNull(getLeadsResponse);
    }
}