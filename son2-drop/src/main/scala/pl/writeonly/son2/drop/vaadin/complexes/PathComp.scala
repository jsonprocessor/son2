package pl.writeonly.son2.drop.vaadin.complexes
import com.vaadin.ui.Component
import pl.writeonly.son2.drop.vaadin.util.UITrait

class ComplexPath extends Complex {
  val provider = new PathProviderComp
  val options = new PathOptionsComp
  val layout = ComplexPath.horizontalLayout(provider.toComponent, options.toComponent)
  override def toComponent: Component = layout
}

object ComplexPath extends UITrait
