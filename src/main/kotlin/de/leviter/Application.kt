package de.leviter

import de.leviter.account.handleSignIn
import de.leviter.account.handleSignUp
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    routing {
        get("/") {
            call.respondText("No customers found", status = HttpStatusCode.OK)
        }
        handleSignUp()
        handleSignIn()
    }
}
