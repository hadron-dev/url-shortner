package dev.hadron.plugins

import dev.hadron.resources.statusRoutes
import dev.hadron.resources.getRedirect
import dev.hadron.resources.shortenUrls
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        statusRoutes()
        getRedirect()
        shortenUrls()
    }
}
