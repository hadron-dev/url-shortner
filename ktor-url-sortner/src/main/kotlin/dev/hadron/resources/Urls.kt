package dev.hadron.resources

import dev.hadron.data.ShortenedUrl
import dev.hadron.data.ShortenedUrlRequestBody
import dev.hadron.data.UrlRepository
import io.ktor.http.*
import io.ktor.resources.*
import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.*

@Resource("/urls")
class AllUrls {
    @Resource("shorten")
    data class Shorten(val parent: AllUrls = AllUrls())
}

fun Routing.shortenUrls() {

    get<AllUrls> {
        call.respond(HttpStatusCode.OK, UrlRepository.data)
    }

    post<AllUrls.Shorten, ShortenedUrlRequestBody> { resource, body ->
        val urlKey = UUID.randomUUID().toString()
        val shortenedUrl = ShortenedUrl(
            id = System.currentTimeMillis(),
            url = body.url,
            description = body.description,
            urlKey = urlKey
        )
        UrlRepository.data.add(shortenedUrl)
        call.respond(
            ShortenedUrl(
                id = 0,
                url = body.url,
                urlKey = "test",
                description = body.description
            )
        )
    }
}