package pl.writeonly.son2.drop.vaadin.composites

import com.vaadin.ui.{Component, TextArea}
import pl.writeonly.son2.drop.vaadin.util.UIUtil

class CompositeIO extends Composite {
  val input = inputTextArea
  val output = CompositeIO.outputLabel

  def inputTextArea: TextArea = CompositeIO.inputTextArea("Input json:")

  override def components: List[Component] = ???
}

object CompositeIO extends UIUtil {

}
