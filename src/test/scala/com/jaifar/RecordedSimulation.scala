package com.jaifar

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://computer-database.gatling.io")
		.inferHtmlResources()
		.acceptHeader("text/css,*/*;q=0.1")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.9")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_9 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Cache-Control" -> "max-age=0",
		"Origin" -> "http://computer-database.gatling.io",
		"Upgrade-Insecure-Requests" -> "1")



	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/assets/css/main.css"),
            http("request_2")
			.get("/assets/css/bootstrap.min.css")))
		.pause(4)
		.exec(http("request_3")
			.get("/computers?f=amstrad")
			.headers(headers_0)
			.resources(http("request_4")
			.get("/assets/css/main.css"),
            http("request_5")
			.get("/assets/css/bootstrap.min.css")))
		.pause(13)
		.exec(http("request_6")
			.get("/computers/411")
			.headers(headers_0)
			.resources(http("request_7")
			.get("/assets/css/main.css"),
            http("request_8")
			.get("/assets/css/bootstrap.min.css")))
		.pause(3)
		.exec(http("request_9")
			.post("/computers/411")
			.headers(headers_9)
			.formParam("name", "Amstrad CPC")
			.formParam("introduced", "")
			.formParam("discontinued", "")
			.formParam("company", "36")
			.resources(http("request_10")
			.get("/assets/css/main.css"),
            http("request_11")
			.get("/assets/css/bootstrap.min.css")))

	setUp(scn.inject(atOnceUsers(100))).protocols(httpProtocol)
}