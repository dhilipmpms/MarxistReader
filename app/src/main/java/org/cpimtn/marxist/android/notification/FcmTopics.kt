package org.cpimtn.marxist.android.notification

/**
 * In the F-Droid build, proprietary Google Play Services and Firebase Cloud Messaging are removed.
 * This function is retained as a no-op so callers (e.g. in [org.cpimtn.marxist.android.app.MarxistReaderApp])
 * remain source-compatible without proprietary dependencies.
 */
fun subscribeToNewBookTopic() {
    // No-op in F-Droid / FOSS builds without proprietary Firebase Messaging.
}
