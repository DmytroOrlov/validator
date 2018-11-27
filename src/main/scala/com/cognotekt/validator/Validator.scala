package com.cognotekt.validator

import scala.collection.breakOut
import scala.io.Source
import scala.util.Try

object Validator {

  import States._

  val items: Map[String, Int] =
    Source
      .fromResource("acceptedLineItems.csv")
      .getLines
      .toStream
      .map { s =>
        val vs = s.split(",")
        vs(0) -> vs(1).toInt
      }(breakOut)

  val limit: Map[String, Int] = items.withDefaultValue(0)


  def validateLine(line: String): String = {
    val vs = line.split(",")
    if (vs(1).toInt <= limit(vs(0))) valid else invalid
  }

  def validateBill(filename: String): String =
    Try {
      val lines = Source.fromResource(filename).getLines
      if (lines.forall(s => validateLine(s) == valid)) valid
      else invalid
    }.getOrElse(error)
}

object States {
  val valid = "valid"
  val invalid = "invalid"
  val error = "error"
}
