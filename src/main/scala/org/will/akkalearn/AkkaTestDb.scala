package org.will.akkalearn

import akka.actor.Actor
import akka.event.Logging

import scala.collection.mutable

/**
  * Created by william on 29/05/16.
  */
class AkkaTestDb extends Actor {

  val logger = Logging(context.system, this)
  val map = new mutable.HashMap[String, Any]()

  override def receive = {
    case SetRequest(key, value) => logger.info("received SetRequest - key: {}, value: {}", key, value)
      map.put(key, value)
    case _ => logger.info("received unknown message class")
  }

}
