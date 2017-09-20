package pl.writeonly.son2.drop.vaadin.complexes

import com.vaadin.ui.Component
import pl.writeonly.son2.drop.vaadin.util.{ItemSymbol, UIUtil}

import scala.collection.JavaConverters._

object ComplexRW extends UIUtil {
  val natives = List("Print", "String")

  val readMapping = Set[ItemSymbol](
    ItemSymbol('all, "All line" ),
    ItemSymbol('stream, "Line-by-line")
  )

  val writeMapping = Set[ItemSymbol](
    ItemSymbol('pretty, "Pretty"),
    ItemSymbol('raw,  "Raw")
  )

  def readGroupApply = radioButtonGroup2("Read:", ComplexRW.readMapping)

  def writeGroupApply = radioButtonGroup2("Write:", ComplexRW.writeMapping)

  def nativeGroupApply = checkBoxGroup("Native:", ComplexRW.natives)
}

abstract class ComplexRW extends Complex {
  private val readGroup = ComplexRW.readGroupApply
  private val writeGroup = ComplexRW.writeGroupApply
  private val nativeGroup = ComplexRW.nativeGroupApply
  protected val components: List[Component] = List(readGroup, writeGroup, nativeGroup)

  def readStream = readSelectedItem.equals('stream)

  def readSelectedItem = ComplexRW.selectedItem2(readGroup).value

  def writePretty = writeSelectedItem.equals('pretty)

  def writeSelectedItem = ComplexRW.selectedItem2(writeGroup).value

  def set = nativeGroup.getValue.asScala.toSet
}

class ComplexRWHorizontal extends ComplexRW {
  private val component: Component = ComplexJackFormats.horizontalLayout(components: _*)

  override def toComponent: Component = component
}

class ComplexRWVertical extends ComplexRW {
  private val component: Component = ComplexJackFormats.verticalLayout(components: _*)

  override def toComponent: Component = component
}

