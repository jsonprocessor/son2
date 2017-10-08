package pl.writeonly.son2.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import com.vaadin.ui.themes.ValoTheme
import pl.writeonly.son2.core.util.{CompareConfig, JsonComparator}
import pl.writeonly.son2.vaadin.util.ItemSymbol

@Title("json comparator")
@Theme("valo")
class UIComparator extends UITrait2 {

  override def componentsCenter2: Components = new Components() {
    val inputLeft = inputTextArea("Expected json:")
    val inputRight = inputTextArea("Actual json:")
    val output = outputLabel

    val modeGroup = checkBoxGroup(null, UIComparator.items)
    modeGroup.addStyleName(ValoTheme.OPTIONGROUP_HORIZONTAL)

    val components: List[Component] = List(modeGroup)

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val selected = selectedItem(modeGroup)
        val extensible = selected.contains(UIComparator.extensible)
        val strictOrder = selected.contains(UIComparator.strictOrder)
        val config = CompareConfig(extensible, strictOrder)
        val value = JsonComparator(config, inputLeft.getValue, inputRight.getValue)
        output.setValue(value)
      }
    })
    val optionPanel = optionsPanel(components)
    val inputs = List(inputLeft, inputRight)
  }
}

object UIComparator {
  private val extensible = ItemSymbol('extensible, "Extensible")
  private val strictOrder = ItemSymbol('strictOrder, "Strict Order")
  private val items = Set(extensible, strictOrder)
}