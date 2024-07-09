package dev.hadron.data

import kotlinx.serialization.Serializable

@Serializable
data class ShortenedUrlRequestBody(
    val url: String,
    val description: String? = null
)
