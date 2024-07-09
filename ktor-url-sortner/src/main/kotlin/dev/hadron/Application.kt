package dev.hadron

import dev.hadron.data.environment.DeploymentEnvironment
import dev.hadron.data.environment.DeploymentInfo
import dev.hadron.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    configureHTTP()
    configureMonitoring()
    configureTypeSafeRouting()
    configureRouting()
}

val Application.deploymentInfo: DeploymentInfo
    get() {
        val envProperty = environment.config.property("ktor.environment")
        val env = DeploymentEnvironment.valueOf(envProperty.getString().uppercase())
        val revisionProperty = environment.config.property("ktor.revision").getString()

        return DeploymentInfo(
            environment = env,
            revision = revisionProperty,
        )
    }