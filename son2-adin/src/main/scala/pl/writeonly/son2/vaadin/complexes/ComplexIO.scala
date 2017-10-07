package pl.writeonly.son2.vaadin.complexes

import com.vaadin.ui.TextArea
import pl.writeonly.son2.vaadin.util.UIUtil

class ComplexIO {
  val input = inputTextArea
  val output = ComplexIO.outputLabel

  def inputTextArea: TextArea = ComplexIO.inputTextArea("Input json:")
}

object ComplexIO extends UIUtil {

}
