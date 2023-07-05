package de.leviter

import de.leviter.account.handleSignIn
import de.leviter.account.handleSignUp
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File
import java.nio.file.Files

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    val file = File("openapi/documentation.yaml")

    if (!file.exists())
        file.mkdir()

    Application::class.java.getResourceAsStream("/openapi/documentation.yaml").use {
        if (it != null)
            Files.copy(it, file.toPath())
    }

    install(CORS) {
        anyHost()
        allowHeader(HttpHeaders.ContentType)
    }

    routing {
        swaggerUI(path = "swagger", swaggerFile = "openapi/documentation.yaml")

        get("/") {
            call.respondText("No customers found", status = HttpStatusCode.OK)
        }
        handleSignUp()
        handleSignIn()
    }
}
