package org.amitayh.invoices.common.domain

sealed trait InvoiceError {
  def message: String
}

case class VersionMismatch(actual: Option[Int], expected: Option[Int]) extends InvoiceError {
  override def message: String = s"Version mismatch - expected '$expected', actually '$actual'"
}

case class LineItemDoesNotExist(index: Int) extends InvoiceError {
  override def message: String = s"Line item #$index does not exist"
}

case class InvoiceDoesNotExist() extends InvoiceError {
  override def message: String = s"Trying to modify the state of a non-existing Invoice"
}

case class InvoiceAlreadyExists() extends InvoiceError {
  override def message: String = s"Trying to create an invoice that already exists"
}