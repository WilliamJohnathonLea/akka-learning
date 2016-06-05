package org.will.akkalearn

import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout
import org.scalatest.time.{Millis, Seconds, Span}

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by william on 05/06/16.
  */
class PongActorSpec extends TestBase {

  implicit val defaultPatience = PatienceConfig(timeout = Span(5, Seconds), interval = Span(500, Millis))
  implicit val askTimeout = Timeout(5 seconds)
  val actorSystem = ActorSystem()

  "PongActor" should "respond with 'Pong' if it receives a 'Ping' message" in {
    val actorRef = actorSystem.actorOf(Props(classOf[PongActor]))
    val future = actorRef ? "Ping"

    whenReady(future) { result =>
      result should be("Pong")
    }
  }

  it should "return a failure if it receives an unknown message" in {
    val actorRef = actorSystem.actorOf(Props(classOf[PongActor]))
    val future = actorRef ? "unknown"

    intercept[Exception] {
      Await.result(future.mapTo[String], 1 second)
      assert(false) // Hopefully, this shouldn't be called
    }
  }

}
