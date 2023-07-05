package de.leviter.account

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlin.random.Random

fun Route.handleSignIn() {
    get("/account/signin/") {

        if (Random.nextBoolean()) {
            call.respondText("successfully")
        } else {
            call.respondText("failed")
        }
    }
}
