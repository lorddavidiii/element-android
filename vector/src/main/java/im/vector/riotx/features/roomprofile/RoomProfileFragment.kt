/*
 * Copyright 2019 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package im.vector.riotx.features.roomprofile

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import com.airbnb.epoxy.EpoxyController
import com.airbnb.mvrx.args
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import im.vector.riotx.R
import im.vector.riotx.core.platform.VectorBaseFragment
import kotlinx.android.parcel.Parcelize
import javax.inject.Inject

@Parcelize
data class RoomProfileArgs(
        val roomId: String
) : Parcelable

class RoomProfileFragment @Inject constructor(
        private val roomProfileController: RoomProfileController,
        val roomProfileViewModelFactory: RoomProfileViewModel.Factory
) : VectorBaseFragment() {

    private val roomProfileArgs: RoomProfileArgs by args()
    private val roomProfileViewModel: RoomProfileViewModel by fragmentViewModel()

    override fun getLayoutResId() = R.layout.fragment_room_profile

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun invalidate() = withState(roomProfileViewModel) {
        roomProfileController.setData(it)
    }


}
