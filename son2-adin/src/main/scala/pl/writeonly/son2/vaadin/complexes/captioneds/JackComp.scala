package pl.writeonly.son2.vaadin.complexes.captioneds

import pl.writeonly.son2.vaadin.complexes.ComplexWithCaption
import pl.writeonly.son2.vaadin.complexes.hasselecteditems.JackFormatComp
import pl.writeonly.son2.vaadin.util.UIUtil

class JackComp extends ComplexWithCaption("Jackson") {
  protected val inputFormats = JackFormatComp.jacksonInputFormat
  protected val outputFormats = JackFormatComp.jacksonOutputFormat
  private val layout = JackComp.horizontalLayout(inputFormats, outputFormats)
  set(layout)

  def inputSelectedItem = inputFormats.selectedItem

  def outputSelectedItem = outputFormats.selectedItem
}

object JackComp extends UIUtil
