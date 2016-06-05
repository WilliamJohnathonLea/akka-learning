package org.will.akkalearn

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by william on 29/05/16.
  */
abstract class TestBase extends FlatSpec
  with Matchers
  with ScalaFutures
