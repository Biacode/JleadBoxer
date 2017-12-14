package org.biacode.jleadboxer.client.dataset;

import kotlin.Unit;
import org.biacode.jleadboxer.client.JLeadBoxerClient;
import org.biacode.jleadboxer.client.helper.ResourceClientHelper;
import org.biacode.jleadboxer.model.dataset.CreateDatasetRequest;
import org.biacode.jleadboxer.model.dataset.DeleteDatasetRequest;
import org.biacode.jleadboxer.test.AbstractJLeadBoxerUnitTest;
import org.junit.Test;

/**
 * Created by Arthur Asatryan.
 * Date: 12/6/17
 * Time: 6:22 PM
 */
public class TestDatasetJava extends AbstractJLeadBoxerUnitTest {
    @Test
    public void testCreateDataset() {
        JLeadBoxerClient.INSTANCE.getDataset().createAsync(
                new CreateDatasetRequest("api-key", "user-email"),
                ResourceClientHelper.INSTANCE.ignoreHandling()
        );
    }

    @Test
    public void testDeleteDataset() {
        JLeadBoxerClient.INSTANCE.getDataset().deleteAsync(
                new DeleteDatasetRequest(
                        "dataset-id",
                        "user-email",
                        "api-key"
                ), ((request, response, deleteDatasetResponseFuelErrorResult) -> {
                    deleteDatasetResponseFuelErrorResult.get().getResponseMessage();
                    return Unit.INSTANCE;
                })
        );
    }
}