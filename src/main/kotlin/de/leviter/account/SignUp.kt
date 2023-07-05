package de.leviter.account

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.handleSignUp() {
    get("/account/signup/") {
        call.respondText("No customejkrs found", status = HttpStatusCode.OK)
    }
}