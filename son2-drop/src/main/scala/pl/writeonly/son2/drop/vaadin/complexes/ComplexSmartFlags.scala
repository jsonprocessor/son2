package pl.writeonly.son2.drop.vaadin.complexes
import com.vaadin.ui.Component
import pl.writeonly.son2.drop.vaadin.util.{ItemSymbol, UITrait}

class ComplexSmartFlags extends Complex{
  val flags = ComplexSmartFlags.checkBoxGroup2("Smart flags:", ComplexSmartFlags.items)
  val vertical = ComplexSmartFlags.verticalLayout(flags)
  override def toComponent: Component = vertical
}

object ComplexSmartFlags extends UITrait {
  val items = Set(
    ItemSymbol('FLAG_PROTECT_KEYS, "Protect keys"),
    ItemSymbol('FLAG_PROTECT_4WEB, "Protect 4web"),
    ItemSymbol('FLAG_PROTECT_VALUES, "Protect values"),
    ItemSymbol('FLAG_AGRESSIVE, "Aggressive"),
    ItemSymbol('FLAG_IGNORE_NULL, "Ignore null")
  )
}