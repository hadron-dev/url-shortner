package dev.hadron.resources

import dev.hadron.deploymentInfo
import io.ktor.http.*
import io.ktor.resources.*
import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

@Resource("/status")
data object Status

fun Routing.statusRoutes() {
    get<Status> {
        call.respond(HttpStatusCode.OK, call.application.deploymentInfo)
    }
}