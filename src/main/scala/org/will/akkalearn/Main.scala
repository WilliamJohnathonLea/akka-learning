package org.will.akkalearn

import java.util.concurrent.TimeUnit

import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout

/**
  * Created by william on 05/07/16.
  */
object Main {
  def main(args: Array[String]) : Unit = {
    implicit val timeout = Timeout(5, TimeUnit.SECONDS)
    val system = ActorSystem("mySystem")
    val actor = system.actorOf(Props[MyActor])
    actor ? 1 map(_ => system.terminate())
  }
}
