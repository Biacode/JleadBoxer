package org.biacode.jleadboxer;

import com.github.kittinunf.fuel.core.Request;
import kotlin.Unit;
import org.biacode.jleadboxer.client.JLeadBoxerClient;
import org.biacode.jleadboxer.client.helper.ResourceClientHelper;
import org.biacode.jleadboxer.model.dataset.CreateDatasetRequest;
import org.biacode.jleadboxer.model.dataset.DeleteDatasetRequest;
import org.biacode.jleadboxer.test.AbstractJLeadBoxerUnitTest;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;

/**
 * Created by Arthur Asatryan.
 * Date: 12/6/17
 * Time: 6:22 PM
 */
public class TestJavaApplication extends AbstractJLeadBoxerUnitTest {
    @Test
    public void testCreateDataset() {
        JLeadBoxerClient.INSTANCE.getDataset().create(
                new CreateDatasetRequest(
                        "api-key",
                        "user-email",
                        "account-id",
                        "Europe/Amsterdam",
                        new HashSet<>(Collections.singletonList(3839))
                ),
                ResourceClientHelper.INSTANCE.ignoreHandling());
    }

    @Test
    public void testDeleteDataset() {
        final Request delete = JLeadBoxerClient.INSTANCE.getDataset().delete(
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