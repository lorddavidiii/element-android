/*
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

package im.vector.matrix.android.internal.crypto.store.db.query

import im.vector.matrix.android.internal.crypto.store.db.model.UserEntity
import im.vector.matrix.android.internal.crypto.store.db.model.UserEntityFields
import io.realm.Realm
import io.realm.kotlin.where

/**
 * Get or create a user
 */
internal fun UserEntity.Companion.getOrCreate(realm: Realm, userId: String): UserEntity {
    return realm.where<UserEntity>()
            .equalTo(UserEntityFields.USER_ID, userId)
            .findFirst()
            ?: let {
                realm.createObject(UserEntity::class.java, userId)
            }
}

/**
 * Delete a user
 */
internal fun UserEntity.Companion.delete(realm: Realm, userId: String) {
    realm.where<UserEntity>()
            .equalTo(UserEntityFields.USER_ID, userId)
            .findFirst()
            ?.deleteFromRealm()
}
