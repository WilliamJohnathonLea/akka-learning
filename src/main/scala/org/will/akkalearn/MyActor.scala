package org.will.akkalearn

import akka.actor.{Actor, Props}

/**
  * Created by william on 05/07/16.
  */
class MyActor extends Actor {


  override def receive = {
    case x: Int => println(s"Received number $x")
  }

}

object MyActor {
  def props = Props[MyActor]
}
