package ru.mg.gatling.web

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class AccountsWSStubDelayed extends Simulation {
  val httpProtocol = http
    .baseUrl("http://localhost:8080")
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")

  val scn = scenario("AccountsWSStub")
    .repeat(1) ( exec(http("AccountsWSStubCall")
      .post("/service/accounts/delayed")
    ))

  setUp(
    scn.inject(constantUsersPerSec(500) during (2 minutes))
  ).protocols(httpProtocol)
}
