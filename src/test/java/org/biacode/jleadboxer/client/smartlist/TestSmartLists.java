package org.biacode.jleadboxer.client.smartlist;

import org.biacode.jleadboxer.client.JLeadBoxerClient;
import org.biacode.jleadboxer.client.helper.ResourceClientHelper;
import org.biacode.jleadboxer.model.smartlist.*;
import org.biacode.jleadboxer.test.AbstractJLeadBoxerUnitTest;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertNotNull;

/**
 * User: Syuzanna Eprikyan
 * Company: SFL LLC
 * Date: 1/12/18
 * Time: 3:09 PM
 */
public class TestSmartLists extends AbstractJLeadBoxerUnitTest {

    @Test
    public void dummyTest() {
    }
}


class TestCases {
    public static void main(String[] args) {
        final GetSmartListsResponse getSmartListsResponse = JLeadBoxerClient.INSTANCE.getSmartList()
                .getSmartListsAsync(
                        new GetSmartListsRequest(AbstractJLeadBoxerUnitTest.LeadBoxerCredentials.INSTANCE.getApiKey(),
                                                 AbstractJLeadBoxerUnitTest.LeadBoxerCredentials.INSTANCE.getAccountId(),
                                                 AbstractJLeadBoxerUnitTest.LeadBoxerCredentials.INSTANCE.getUserEmail(),
                                                 AbstractJLeadBoxerUnitTest.LeadBoxerCredentials.INSTANCE.getDatasetId()
                        ),
                        ResourceClientHelper.INSTANCE.ignoreHandling()
                )
                .responseObject(ResourceClientHelper.INSTANCE.deserializer(GetSmartListsResponse.class))
                .getThird()
                .get();
        assertNotNull(getSmartListsResponse);

        final CreateSmartListResponse createSmartListsResponse = JLeadBoxerClient.INSTANCE.getSmartList()
                .createAsync(
                        new CreateSmartListRequest.Builder(AbstractJLeadBoxerUnitTest.LeadBoxerCredentials.INSTANCE.getApiKey(),
                                                   AbstractJLeadBoxerUnitTest.LeadBoxerCredentials.INSTANCE.getAccountId(),
                                                   AbstractJLeadBoxerUnitTest.LeadBoxerCredentials.INSTANCE.getUserEmail(),
                                                   AbstractJLeadBoxerUnitTest.LeadBoxerCredentials.INSTANCE.getDatasetId(),
                                                   UUID.randomUUID().toString(),
                                                   SmartListType.USER
                        ).build(),
                        ResourceClientHelper.INSTANCE.ignoreHandling()
                )
                .responseObject(ResourceClientHelper.INSTANCE.deserializer(CreateSmartListResponse.class))
                .getThird()
                .get();
        assertNotNull(createSmartListsResponse);
    }
}