package pl.writeonly.son2.drop.vaadin.complexes
import com.vaadin.ui.Component
import pl.writeonly.son2.drop.vaadin.util.UITrait

class ComplexPath extends Complex {
  val provider = new PathProviderComp
  val options = new PathOptionsComp
  val root = ComplexPath.horizontalLayout(provider, options)
  setCompositionRoot(root)
//  override def toComponent: Component = this
}

object ComplexPath extends UITrait
