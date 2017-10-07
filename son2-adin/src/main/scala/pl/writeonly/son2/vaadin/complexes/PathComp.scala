package pl.writeonly.son2.vaadin.complexes

import pl.writeonly.son2.vaadin.util.UITrait

class ComplexPath extends Complex {
  setCaption("Path")
  val provider = new PathProviderComp
  val options = new PathOptionsComp
  val root = ComplexPath.horizontalLayout(provider, options)
  set(root)
}

object ComplexPath extends UITrait
