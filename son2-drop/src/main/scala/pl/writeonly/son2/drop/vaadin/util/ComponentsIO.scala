package pl.writeonly.son2.drop.vaadin.util

import com.vaadin.ui.TextArea

class ComponentsIO extends UIUtil {
  val input = inputTextArea
  val output = outputLabel

  def inputTextArea: TextArea = inputTextArea("Input json:")
}
