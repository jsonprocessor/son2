package pl.writeonly.son2.drop.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import com.vaadin.ui.themes.ValoTheme
import pl.writeonly.son2.core.util.{CompareConfig, JsonComparator}
import pl.writeonly.son2.drop.vaadin.util.{Mappings, UITrait}

@Title("json comparator")
@Theme("valo")
class UIComparator extends UITrait {

  override def componentsCenter: List[Component] = {
    val inputLeft = inputTextArea("Expected json:")
    val inputRight = inputTextArea("Actual json:")
    val output = outputLabel
    val configLabel = outputLabel

    val modeGroup = checkBoxGroup(null, UIComparator.modeSymbolMapping)
    modeGroup.addStyleName(ValoTheme.OPTIONGROUP_HORIZONTAL)

    val components: List[Component] = List(modeGroup, configLabel)

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val selected = selectedItem(modeGroup, UIComparator.modeSymbolMapping)
        val extensible = selected.contains('extensible)
        val strictOrder = selected.contains('strictOrder)
        val config = CompareConfig(extensible, strictOrder)
        debug(configLabel, config, selected)
        val value = JsonComparator(config, inputLeft.getValue, inputRight.getValue)
        output.setValue(value)
      }
    })
    return List(optionsPanel(components), inputLeft, inputRight, convert, output)
  }
}

object UIComparator {
  private val modeSymbolMapping = Map[String, Symbol](
    "Extensible" -> 'extensible,
    "Strict Order" -> 'strictOrder
  )
}