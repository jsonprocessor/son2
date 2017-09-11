package pl.writeonly.son2.drop.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import com.vaadin.ui.themes.ValoTheme
import pl.writeonly.son2.core.util.{CompareConfig, JsonComparator}
import pl.writeonly.son2.drop.vaadin.util.{Mappings, TopMenu, UITrait}

@Title("json comparator")
@Theme("valo")
class UIComparator extends UITrait {

  override def components: List[Component] = {
    val inputLeft = inputTextArea("Expected json:")
    val inputRight = inputTextArea("Actual json:")
    val output = outputLabel
    val configLabel = outputLabel

    val modeGroup = checkBoxGroup("", Mappings.modeSymbolMapping)
    modeGroup.addStyleName(ValoTheme.OPTIONGROUP_HORIZONTAL)

    val components: List[Component] = List(modeGroup, configLabel)

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val selected = getSelectedItem(modeGroup, Mappings.modeSymbolMapping)
        val extensible = selected.contains('extensible)
        val strictOrder = selected.contains('strictOrder)
        val config = CompareConfig(extensible, strictOrder)
        debug(configLabel, config, selected)
        val value = JsonComparator(config, inputLeft.getValue, inputRight.getValue)
        output.setValue(value)
      }
    })
    return List(new TopMenu().linkPanel, optionsPanel(components), inputLeft, inputRight, convert, output)
  }
}
