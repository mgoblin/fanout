package ru.mg.gatling.web

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class AccountsWCSingleDelayed extends Simulation {
  val httpProtocol = http
    .baseUrl("http://localhost:9090")
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")

  val scn = scenario("AccountsWCSingleDelayed")
    .repeat(1) ( exec(http("AccountsWCSingleDelayed")
      .get("/wc/delayed/single")
    ))

  setUp(
    scn.inject(constantUsersPerSec(350) during (2 minutes))
  ).protocols(httpProtocol)
}
