package pl.writeonly.son2.drop.vaadin.complexes

import com.vaadin.ui.TextArea
import pl.writeonly.son2.drop.vaadin.util.UIUtil

class ComplexIO {
  val input = inputTextArea
  val output = ComplexIO.outputLabel

  def inputTextArea: TextArea = ComplexIO.inputTextArea("Input json:")
}

object ComplexIO extends UIUtil {

}
