/*
 * Léon - The URL Cleaner
 * Copyright (C) 2022 Sven Jacobs
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.svenjacobs.app.leon.feature.sanitizer.twitter

import android.content.Context
import com.svenjacobs.app.leon.core.domain.sanitizer.Sanitizer
import com.svenjacobs.app.leon.core.domain.sanitizer.SanitizerId
import com.svenjacobs.app.leon.core.domain.sanitizer.SanitizerRegistration
import javax.inject.Inject
import javax.inject.Provider

class TwitterSanitizerRegistration @Inject constructor(
    private val sanitizerProvider: Provider<TwitterSanitizer>,
) : SanitizerRegistration {

    override val sanitizer: Sanitizer
        get() = sanitizerProvider.get()

    override val id = SanitizerId("twitter")

    override val hasSettingsScreen = false

    override fun getName(context: Context) =
        context.getString(R.string.feat_sanitizer_twitter_name)

    override fun matchesDomain(input: String) =
        DOMAIN_REGEX.containsMatchIn(input)

    private companion object {
        private val DOMAIN_REGEX = Regex("twitter\\.com")
    }
}
