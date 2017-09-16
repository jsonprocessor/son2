package pl.writeonly.son2.drop.vaadin.complexes

import com.vaadin.ui.{Component, TextArea}
import pl.writeonly.son2.drop.vaadin.util.UIUtil

class ComplexIO extends Complex {
  val input = inputTextArea
  val output = ComplexIO.outputLabel

  def inputTextArea: TextArea = ComplexIO.inputTextArea("Input json:")

  override def toComponent: Component = ???

  override def components: List[Component] = ???

}

object ComplexIO extends UIUtil {

}
