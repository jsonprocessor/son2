package pl.writeonly.son2.vaadin.complexes.hasselecteditems

import com.typesafe.scalalogging.LazyLogging
import com.vaadin.ui.Button
import com.vaadin.ui.Button.ClickEvent
import pl.writeonly.son2.vaadin.complexes.{Complex, HasCheckBoxSelectedItem}
import pl.writeonly.son2.vaadin.util.{ItemSymbol, UIUtil}

class SmartOptionsComp extends Complex with HasCheckBoxSelectedItem with LazyLogging {
  private val options = SmartOptionsComp.apply
  private val MODE_PERMISSIVE = button("Permissive", SmartOptionsComp.MODE_PERMISSIVE)
  private val MODE_JSON_SIMPLE = button("Json simple", SmartOptionsComp.MODE_JSON_SIMPLE)
  private val MODE_RFC4627 = button("RFC4627", SmartOptionsComp.MODE_RFC4627)
  private val MODE_STRICTEST = button("Stric Test", SmartOptionsComp.MODE_STRICTEST)
  private val modes = List(MODE_PERMISSIVE, MODE_JSON_SIMPLE, MODE_RFC4627, MODE_STRICTEST)
  private val vertical = SmartOptionsComp.verticalPanel("Smart modes:", modes: _*)
  private val horizontal = SmartOptionsComp.horizontalLayout(vertical, options)
  set(horizontal)

  def selectedItem = SmartOptionsComp.selectedItem(options).map(_.value)

  private def button(caption: String, select: Set[ItemSymbol]) = new Button(caption, new Button.ClickListener() {
    override def buttonClick(event: ClickEvent): Unit = {
      logger.info("button event {}", event)
      logger.info("button select {}", select)
      options.clear()
      options.select(select.toSeq: _*)
    }
  })
}

object SmartOptionsComp extends UIUtil {
  private val ACCEPT_USELESS_COMMA = ItemSymbol('ACCEPT_USELESS_COMMA)
  private val USE_HI_PRECISION_FLOAT = ItemSymbol('USE_HI_PRECISION_FLOAT)
  private val ACCEPT_TAILLING_DATA = ItemSymbol('ACCEPT_TAILLING_DATA)
  private val ACCEPT_TAILLING_SPACE = ItemSymbol('ACCEPT_TAILLING_SPACE)
  private val REJECT_127_CHAR = ItemSymbol('REJECT_127_CHAR)
  private val USE_INTEGER_STORAGE = ItemSymbol('USE_INTEGER_STORAGE)

  private val items1 = Set(
    USE_INTEGER_STORAGE,
    ACCEPT_USELESS_COMMA,
    USE_HI_PRECISION_FLOAT,
    ACCEPT_TAILLING_DATA,
    ACCEPT_TAILLING_SPACE,
    REJECT_127_CHAR)
  private val items2 = Set(
    ItemSymbol('ACCEPT_SIMPLE_QUOTE),
    ItemSymbol('ACCEPT_NON_QUOTE),
    ItemSymbol('ACCEPT_NAN),
    ItemSymbol('IGNORE_CONTROL_CHAR),
    ItemSymbol('ACCEPT_LEADING_ZERO))

  private val items = items1 ++ items2
  private val MODE_JSON_SIMPLE: Set[ItemSymbol] = Set(
    ACCEPT_USELESS_COMMA,
    USE_HI_PRECISION_FLOAT,
    ACCEPT_TAILLING_DATA,
    ACCEPT_TAILLING_SPACE,
    REJECT_127_CHAR)
  private val MODE_RFC4627: Set[ItemSymbol] = Set(
    USE_INTEGER_STORAGE,
    USE_HI_PRECISION_FLOAT,
    ACCEPT_TAILLING_SPACE)
  private val MODE_STRICTEST: Set[ItemSymbol] = Set(
    USE_INTEGER_STORAGE,
    USE_HI_PRECISION_FLOAT,
    REJECT_127_CHAR)
  private val MODE_PERMISSIVE: Set[ItemSymbol] = items

  private def apply = checkBoxGroup("Smart options:", items)

}
