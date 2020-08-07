package ru.mg.gatling.web

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class AccountsStubPackageFlux extends Simulation {
  val httpProtocol = http
    .baseUrl("http://localhost:9090")
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")

  val scn = scenario("AccountsStubPackageFlux")
    .repeat(1) ( exec(http("getAccountsPackageFluxFromStub")
      .get("/stub/package/flux")
    ))

  setUp(
    scn.inject(constantUsersPerSec(1000) during (2 minutes))
  ).protocols(httpProtocol)
}
