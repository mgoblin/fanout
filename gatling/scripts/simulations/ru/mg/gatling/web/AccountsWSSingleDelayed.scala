package ru.mg.gatling.web

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class AccountsWSSingleDelayed extends Simulation {
  val httpProtocol = http
    .baseUrl("http://localhost:9090")
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")

  val scn = scenario("AccountsWSSingleDelayed")
    .repeat(1) ( exec(http("AccountsWSSingleDelayed")
      .get("/ws/delayed/single")
    ))

  setUp(
    scn.inject(constantUsersPerSec(500) during (2 minutes))
  ).protocols(httpProtocol)
}
