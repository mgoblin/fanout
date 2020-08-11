package ru.mg.gatling.web

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class AccountsWCSingleFast extends Simulation {
  val httpProtocol = http
    .baseUrl("http://localhost:9090")
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")

  val scn = scenario("AccountsWCSingleFast")
    .repeat(1) ( exec(http("AccountsWCSingleFast")
      .get("/wc/fast/single")
    ))

  setUp(
    scn.inject(constantUsersPerSec(400) during (2 minutes))
  ).protocols(httpProtocol)
}
