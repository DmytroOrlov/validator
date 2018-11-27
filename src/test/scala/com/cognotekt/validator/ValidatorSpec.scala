package com.cognotekt.validator

import org.scalatest.{ FlatSpec, Matchers }

class ValidatorSpec extends FlatSpec with Matchers {
  val line1: String = "Kotfluegelreparatur,10000"
  val line2: String = "Kotfluegelreparatur,20000"

  "Cheap Kotfluegelreparatur" should "be valid" in {
    Validator.validateLine(line1) shouldEqual "valid"
  }
  "Overpriced Kotfluegelreparatur" should "be invalid" in {
    Validator.validateLine(line2) shouldEqual "invalid"
  }

  "Bill1" should "be invalid" in {
    Validator.validateBill("bills/bill1.csv") shouldEqual "invalid"
  }

  "Bill2" should "be valid" in {
    Validator.validateBill("bills/bill2.csv") shouldEqual "valid"
  }

  "Bill3" should "be invalid" in {
    Validator.validateBill("bills/bill3.csv") shouldEqual "invalid"
  }

  "Bill4" should "be invalid" in {
    Validator.validateBill("bills/bill4.csv") shouldEqual "invalid"
  }
}
