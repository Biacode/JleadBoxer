package org.biacode.jleadboxer;

import kotlin.Unit;
import org.biacode.jleadboxer.client.JLeadBoxerClient;
import org.biacode.jleadboxer.model.dataset.CreateDatasetRequest;
import org.biacode.jleadboxer.test.AbstractJLeadBoxerUnitTest;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.UUID;

/**
 * Created by Arthur Asatryan.
 * Date: 12/6/17
 * Time: 6:22 PM
 */
public class TestJavaApplication extends AbstractJLeadBoxerUnitTest {
    @Test
    public void testDataset() {
        JLeadBoxerClient.INSTANCE.getDataset().createDataset(new CreateDatasetRequest(
                LeadBoxerCredentials.INSTANCE.getApiKey(),
                LeadBoxerCredentials.INSTANCE.getUserEmail(),
                LeadBoxerCredentials.INSTANCE.getAccountId(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                false,
                "Europe/Amsterdam",
                new HashSet<>(Collections.singletonList(3839))
        ), (request, response, result) -> {
            System.out.println(result);
            return Unit.INSTANCE;
        });
    }
}
