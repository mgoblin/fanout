package ru.mg.gatling.web

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class AccountsStubSingle extends Simulation {
  val httpProtocol = http
    .baseUrl("http://localhost:9090")
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")

  val scn = scenario("AccountsStubSingle")
    .repeat(1) ( exec(http("getSingleAccountFromStub")
      .get("/stub/single")
    ))

  setUp(
    scn.inject(constantUsersPerSec(1000) during (2 minutes))
  ).protocols(httpProtocol)
}
