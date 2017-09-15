package pl.writeonly.son2.drop.vaadin.composites

import pl.writeonly.son2.drop.vaadin.util.{Mappings, UIUtil}

import scala.collection.JavaConverters._

class CompositeRW extends Composite {
  val readGroup = CompositeRW.readGroupApply
  val writeGroup = CompositeRW.writeGroupApply
  val nativeGroup = CompositeRW.nativeGroupApply
  val configLabel = CompositeRW.outputLabel

  def readSelectedItem = CompositeRW.selectedItem(readGroup, Mappings.readMapping)

  def readStream = readSelectedItem.equals('stream)

  def writeSelectedItem = CompositeRW.selectedItem(writeGroup, Mappings.writeMapping)

  def writePretty = writeSelectedItem.equals('pretty)

  def components = List(readGroup, writeGroup, nativeGroup, configLabel)

  def set = nativeGroup.getValue.asScala.toSet

}

object CompositeRW extends UIUtil {
  val natives = List("Print", "String")

  def readGroupApply = radioButtonGroup("Read:", Mappings.readMapping)

  def writeGroupApply = radioButtonGroup("Write:", Mappings.writeMapping)

  def nativeGroupApply = checkBoxGroup("Native:", CompositeRW.natives)
}
