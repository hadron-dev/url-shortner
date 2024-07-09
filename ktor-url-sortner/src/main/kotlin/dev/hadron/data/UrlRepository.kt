package dev.hadron.data

object UrlRepository {
    val data = mutableListOf(
        ShortenedUrl(
            id = 1,
            url = "https://rezafaraji93.github.io",
            urlKey = "github",
            description = "My Portfolio"
        ),
        ShortenedUrl(
            id = 2,
            url = "https://rezafaraji93.github.io/MyPortfolio",
            urlKey = "compose",
            description = "My Portfolio with compose multi platform"
        )
    )
}