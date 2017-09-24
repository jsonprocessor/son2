package pl.writeonly.son2.drop.vaadin.complexes

import pl.writeonly.son2.drop.vaadin.util.UITrait

class ComplexPath extends Complex {
  setCaption("Path")
  val provider = new PathProviderComp
  val options = new PathOptionsComp
  val root = ComplexPath.horizontalLayout(provider, options)
  setCompositionRoot(root)
}

object ComplexPath extends UITrait
