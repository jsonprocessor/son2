package pl.writeonly.son2.drop.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import com.vaadin.ui.themes.ValoTheme
import pl.writeonly.son2.core.util.JsonComparator
import pl.writeonly.son2.drop.vaadin.util.{Mappings, TopMenu, UITrait}

@Title("json comparator")
@Theme("valo")
class UIComparator extends UITrait {

  override def components: List[Component] = {
    val inputLeft = inputTextArea("expected json:")
    val inputRight = inputTextArea("actual json:")
    val output = outputLabel

    val modeGroup = radioButtonGroup("Compare mode", Mappings.modeMapping)
    modeGroup.addStyleName(ValoTheme.OPTIONGROUP_HORIZONTAL)

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val mode = selectedItem(modeGroup, Mappings.modeMapping)
        val value = JsonComparator(inputLeft.getValue, inputRight.getValue, mode)
        output.setValue(value)
      }
    })
    return List(new TopMenu().linkPanel, modeGroup, inputLeft, inputRight, convert, output)
  }
}
