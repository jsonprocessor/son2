package pl.writeonly.son2.drop.vaadin.composites

import pl.writeonly.son2.drop.vaadin.util.{Mappings, UIUtil}

import scala.collection.JavaConverters._

class ComplexRW extends Complex {
  private val readGroup = ComplexRW.readGroupApply
  private val writeGroup = ComplexRW.writeGroupApply
  private val nativeGroup = ComplexRW.nativeGroupApply
  val configLabel = ComplexRW.outputLabel

  def readStream = readSelectedItem.equals('stream)

  def readSelectedItem = ComplexRW.selectedItemOpt(readGroup, Mappings.readMapping)

  def writePretty = writeSelectedItem.equals('pretty)

  def writeSelectedItem = ComplexRW.selectedItemOpt(writeGroup, Mappings.writeMapping)

  def components = List(readGroup, writeGroup, nativeGroup, configLabel)

  def set = nativeGroup.getValue.asScala.toSet
}

object ComplexRW extends UIUtil {
  val natives = List("Print", "String")

  def readGroupApply = radioButtonGroup("Read:", Mappings.readMapping)

  def writeGroupApply = radioButtonGroup("Write:", Mappings.writeMapping)

  def nativeGroupApply = checkBoxGroup("Native:", ComplexRW.natives)
}
