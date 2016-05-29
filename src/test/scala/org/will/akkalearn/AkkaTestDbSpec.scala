package org.will.akkalearn

import akka.actor.ActorSystem
import akka.testkit.TestActorRef

/**
  * Created by william on 29/05/16.
  */
class AkkaTestDbSpec extends TestBase {

  implicit val actorSystem = ActorSystem()

  "AkkaTestDb" should "save a message from a SetRequest" in {
    val actorRef = TestActorRef(new AkkaTestDb())
    actorRef ! SetRequest("key", "value")
    val akkaTestDb = actorRef.underlyingActor
    akkaTestDb.map.get("key") should be(Some("value"))
  }

}
