package org.cpimtn.marxist.android.app

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.core.net.toUri
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

/**
 * Handles the review prompt state once the user has read enough articles.
 *
 * In the F-Droid build, proprietary Google Play In-App Review APIs are removed.
 * When [shouldPrompt] is triggered, we record that the prompt was handled so that
 * the gating check is satisfied and does not repeatedly trigger.
 */
@Composable
fun ReviewHost() {
    val viewModel: ReviewViewModel = hiltViewModel()
    val shouldPrompt by viewModel.shouldPrompt.collectAsStateWithLifecycle()

    LaunchedEffect(shouldPrompt) {
        if (!shouldPrompt) return@LaunchedEffect
        viewModel.onPromptAttempted()
    }
}

/**
 * Opens the app's store listing. Used by the Settings entry rather than the in-app review
 * flow. A tap the user made deliberately will open the app store (such as F-Droid or Play Store)
 * via market://, with a web fallback.
 */
fun Context.openPlayStoreListing() {
    val marketIntent = Intent(Intent.ACTION_VIEW, "market://details?id=$packageName".toUri())
        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    try {
        startActivity(marketIntent)
    } catch (_: ActivityNotFoundException) {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                "https://play.google.com/store/apps/details?id=$packageName".toUri(),
            ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK),
        )
    }
}
