/*
 * Copyright 2014 OpenMarket Ltd
 * Copyright 2017 Vector Creations Ltd
 * Copyright 2018 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package im.vector.matrix.android.internal.crypto.model.rest

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import im.vector.matrix.android.api.interfaces.DatedObject

/**
 * This class describes the device information
 */
@JsonClass(generateAdapter = true)
data class DeviceInfo(
        /**
         * The owner user id (not documented and useless but the homeserver sent it. You should not need it)
         */
        @Json(name = "user_id")
        var user_id: String? = null,

        /**
         * The device id
         */
        @Json(name = "device_id")
        var deviceId: String? = null,

        /**
         * The device display name
         */
        @Json(name = "display_name")
        var displayName: String? = null,

        /**
         * The last time this device has been seen.
         */
        @Json(name = "last_seen_ts")
        var lastSeenTs: Long? = null,

        /**
         * The last ip address
         */
        @Json(name = "last_seen_ip")
        var lastSeenIp: String? = null
) : DatedObject {

    override val date: Long
        get() = lastSeenTs ?: 0
}
