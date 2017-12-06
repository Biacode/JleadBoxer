package org.biacode.jleadboxer;

import org.biacode.jleadboxer.client.JLeadBoxerClient;
import org.biacode.jleadboxer.model.dataset.CreateDatasetModel;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.UUID;

/**
 * Created by Arthur Asatryan.
 * Date: 12/6/17
 * Time: 6:22 PM
 */
public class TestJavaApplication {
    @Test
    public void testDataset() {
        LeadBoxerConf.INSTANCE.setupFuel();
        JLeadBoxerClient.INSTANCE.getDataset().createDataset(new CreateDatasetModel(
                LeadBoxerConf.INSTANCE.getApiKey(),
                LeadBoxerConf.INSTANCE.getUserEmail(),
                LeadBoxerConf.INSTANCE.getAccountId(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                false,
                "Europe/Amsterdam",
                new HashSet<>(Collections.singletonList(3839))
        ), (request, response, result) -> null);
    }
}
