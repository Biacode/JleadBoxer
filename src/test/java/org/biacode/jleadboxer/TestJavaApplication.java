package org.biacode.jleadboxer;

import com.github.kittinunf.fuel.core.FuelManager;
import org.biacode.jleadboxer.client.JLeadBoxerClient;
import org.biacode.jleadboxer.model.dataset.CreateDatasetModel;
import org.junit.Test;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.util.*;

/**
 * Created by Arthur Asatryan.
 * Date: 12/6/17
 * Time: 6:22 PM
 */
public class TestJavaApplication {
    @Test
    public void testDataset() {
        setupFuel();
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

    private void setupFuel() {
        FuelManager.Companion.getInstance().setBasePath(LeadBoxerConf.INSTANCE.getBasePath());
        final Map<String, String> headers = new HashMap<>();
        headers.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
        FuelManager.Companion.getInstance().setBaseHeaders(headers);
    }
}
