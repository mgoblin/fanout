package ru.mg.gatling.web

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class AccountsStubPackage extends Simulation {
  val httpProtocol = http
    .baseUrl("http://localhost:9090")
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")

  val scn = scenario("AccountsStubPackage")
    .repeat(1) ( exec(http("getAccountsPackageFromStub")
      .get("/stub/package/1")
    ))

  setUp(
    scn.inject(constantUsersPerSec(1000) during (2 minutes))
  ).protocols(httpProtocol)
}
