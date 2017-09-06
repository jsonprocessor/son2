package pl.writeonly.son2.drop.vaadin.util

import com.vaadin.ui.{CheckBoxGroup, TextArea}

import scala.collection.JavaConverters._

class ComponentsRW extends UIUtil {

  val readGroup = readGroupApply
  val writeGroup = writeGroupApply
  val nativeGroup = nativeGroupApply
  val configLabel = outputLabel

  def readSelectedItem = selectedItem(readGroup, Mappings.readMapping)
  def writeSelectedItem = selectedItem(writeGroup, Mappings.writeMapping)

  def components = List(readGroup, writeGroup, nativeGroup, configLabel)

  def set = nativeGroup.getValue.asScala.toSet


  val natives = List("Print", "String")

  def readGroupApply = radioButtonGroup("Read:", Mappings.readMapping)

  def writeGroupApply = radioButtonGroup("Write:", Mappings.writeMapping)

  def nativeGroupApply = new CheckBoxGroup("Native:", natives.asJavaCollection)




}
