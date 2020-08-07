package ru.mg.gatling.web

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class WSFastStub extends Simulation {
  val httpProtocol = http
    .baseUrl("http://localhost:8080")
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")

  val scn = scenario("WSFastStub")
    .repeat(1) ( exec(http("WSFastStub")
      .post("/service/accounts/fast")
    ))

  setUp(
    scn.inject(constantUsersPerSec(500) during (2 minutes))
  ).protocols(httpProtocol)
}
