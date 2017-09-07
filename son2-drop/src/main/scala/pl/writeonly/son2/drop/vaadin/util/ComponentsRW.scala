package pl.writeonly.son2.drop.vaadin.util

import com.vaadin.ui.CheckBoxGroup

import scala.collection.JavaConverters._

class ComponentsRW extends UIUtil {
  val readGroup = readGroupApply
  val writeGroup = writeGroupApply
  val nativeGroup = nativeGroupApply
  val configLabel = outputLabel

  def readSelectedItem = selectedItem(readGroup, Mappings.readMapping)

  def readStream = readSelectedItem.equals('stream)

  def writeSelectedItem = selectedItem(writeGroup, Mappings.writeMapping)

  def writePretty = writeSelectedItem.equals('pretty)

  def components = List(readGroup, writeGroup, nativeGroup, configLabel)

  def set = nativeGroup.getValue.asScala.toSet

  def readGroupApply = radioButtonGroup("Read:", Mappings.readMapping)

  def writeGroupApply = radioButtonGroup("Write:", Mappings.writeMapping)

  def nativeGroupApply = new CheckBoxGroup("Native:", List("Print", "String").asJavaCollection)

}
