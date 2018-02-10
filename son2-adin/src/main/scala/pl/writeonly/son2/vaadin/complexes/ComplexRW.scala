package pl.writeonly.son2.vaadin.complexes

import com.vaadin.ui.Component
import pl.writeonly.son2.vaadin.util.{ItemSymbol, UIUtil}

import scala.collection.JavaConverters._

object ComplexRW extends UIUtil {
  val nativesItems = List("Print", "String")

  val readItems = Set[ItemSymbol](
    ItemSymbol('all, "All line"),
    ItemSymbol('stream, "Line-by-line"))

  val writeItems = Set[ItemSymbol](
    ItemSymbol('pretty, "Pretty"),
    ItemSymbol('raw, "Raw"))

  def readGroupApply = radioButtonGroup("Read:", ComplexRW.readItems)

  def writeGroupApply = radioButtonGroup("Write:", ComplexRW.writeItems)

  def nativeGroupApply = checkBoxGroupNative("Native:", ComplexRW.nativesItems)
}

abstract class ComplexRW extends Complex {
  private val readGroup = ComplexRW.readGroupApply
  private val writeGroup = ComplexRW.writeGroupApply
  private val nativeGroup = ComplexRW.nativeGroupApply
  protected val components: List[Component] = List(readGroup, writeGroup, nativeGroup)

  def readStream = readSelectedItem.equals('stream)

  def readSelectedItem = ComplexRW.selectedItem(readGroup).value

  def writePretty = writeSelectedItem.equals('pretty)

  def writeSelectedItem = ComplexRW.selectedItem(writeGroup).value

  def set = nativeGroup.getValue.asScala.toSet
}

class ComplexRWHorizontal extends ComplexRW {
  private val component: Component = ComplexRW.horizontalLayout(components: _*)
  set(component)
}

class ComplexRWVertical extends ComplexRW {
  private val component: Component = ComplexRW.verticalLayout(components: _*)
  set(component)
}

