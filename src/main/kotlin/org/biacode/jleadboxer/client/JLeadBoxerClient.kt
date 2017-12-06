package org.biacode.jleadboxer.client

import org.biacode.jleadboxer.client.dataset.impl.DatasetResourceClientImpl
import org.biacode.jleadboxer.client.helper.ResourceClientHelper.readWriteLazy
import org.biacode.jleadboxer.client.leadboard.impl.LeadBoardResourceClientImpl
import org.biacode.jleadboxer.client.smartlist.impl.SmartListResourceClientImpl
import org.biacode.jleadboxer.client.user.impl.UserResourceClientImpl
import org.biacode.jleadboxer.client.userdataset.impl.UserDatasetResourceClientImpl

/**
 * Created by Arthur Asatryan.
 * Date: 12/6/17
 * Time: 5:41 PM
 */
object JLeadBoxerClient {
    val dataset by readWriteLazy { DatasetResourceClientImpl() }

    val leadBoard by readWriteLazy { LeadBoardResourceClientImpl() }

    val smartList by readWriteLazy { SmartListResourceClientImpl() }

    val user by readWriteLazy { UserResourceClientImpl() }

    val userDataset by readWriteLazy { UserDatasetResourceClientImpl() }
}