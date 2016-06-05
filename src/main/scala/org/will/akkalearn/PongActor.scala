package org.will.akkalearn

import akka.actor.{Actor, Status}

/**
  * Created by william on 05/06/16.
  */
class PongActor extends Actor {

  override def receive = {
    case "Ping" => sender() ! "Pong"
    case _ => sender() ! Status.Failure(new Exception("unknown message"))
  }

}
