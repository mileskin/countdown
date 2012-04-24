#!/bin/sh
exec scala "$0" "$@"
!#

import sys.process._

val defaults = List("5", "general")
val overrides = argv.toList
val options = overrides ++ defaults.drop(overrides.size)
val minutes = options.apply(0).toInt
val client = options.apply(1)

"say dear %s resource, countdown begins, u have %s minutes left".format(client, minutes)!

val minute = 60
val totalSeconds = minutes * minute

(1 to totalSeconds).foreach { x =>
  val secondsLeft = totalSeconds - x
  val message = "%s minutes %s seconds left".format(secondsLeft / minute, secondsLeft % minute)
  print("\r" + " " * 100 + "\r%s ".format(message))
  Thread.sleep(1000)
  if (x == totalSeconds - minute) {
    "say dear %s resource, u have 1 minute left".format(client)!
  }
}

"say dear %s resource, ur time is up".format(client)!

println
"toilet --gay time is up"!

