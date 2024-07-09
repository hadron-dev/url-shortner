package dev.hadron.plugins

import io.ktor.server.application.*
import io.ktor.server.resources.*

fun Application.configureTypeSafeRouting() {
    install(Resources)
}