package pl.writeonly.son2.drop.vaadin.composites

import com.vaadin.ui.CheckBoxGroup
import pl.writeonly.son2.drop.vaadin.util.{Mappings, UIUtil}

import scala.collection.JavaConverters._

class ComponentsRW extends Composite {
  val readGroup = ComponentsRW.readGroupApply
  val writeGroup = ComponentsRW.writeGroupApply
  val nativeGroup = ComponentsRW.nativeGroupApply
  val configLabel = ComponentsRW.outputLabel

  def readSelectedItem = ComponentsRW.selectedItem(readGroup, Mappings.readMapping)

  def readStream = readSelectedItem.equals('stream)

  def writeSelectedItem = ComponentsRW.selectedItem(writeGroup, Mappings.writeMapping)

  def writePretty = writeSelectedItem.equals('pretty)

  def components = List(readGroup, writeGroup, nativeGroup, configLabel)

  def set = nativeGroup.getValue.asScala.toSet

}

object ComponentsRW extends UIUtil{
  val natives = List("Print", "String")

  def readGroupApply = radioButtonGroup("Read:", Mappings.readMapping)

  def writeGroupApply = radioButtonGroup("Write:", Mappings.writeMapping)

  def nativeGroupApply = new CheckBoxGroup("Native:", ComponentsRW.natives.asJavaCollection)
}
