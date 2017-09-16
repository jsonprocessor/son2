package pl.writeonly.son2.drop.vaadin.composites

import pl.writeonly.son2.drop.vaadin.util.{Mappings, UIUtil}

import scala.collection.JavaConverters._

class CompositeRW extends Composite {
  private val readGroup = CompositeRW.readGroupApply
  private val writeGroup = CompositeRW.writeGroupApply
  private val nativeGroup = CompositeRW.nativeGroupApply
  val configLabel = CompositeRW.outputLabel

  def readStream = readSelectedItem.equals('stream)

  def readSelectedItem = CompositeRW.selectedItemOpt(readGroup, Mappings.readMapping)

  def writePretty = writeSelectedItem.equals('pretty)

  def writeSelectedItem = CompositeRW.selectedItemOpt(writeGroup, Mappings.writeMapping)

  def components = List(readGroup, writeGroup, nativeGroup, configLabel)

  def set = nativeGroup.getValue.asScala.toSet
}

object CompositeRW extends UIUtil {
  val natives = List("Print", "String")

  def readGroupApply = radioButtonGroup("Read:", Mappings.readMapping)

  def writeGroupApply = radioButtonGroup("Write:", Mappings.writeMapping)

  def nativeGroupApply = checkBoxGroup("Native:", CompositeRW.natives)
}
