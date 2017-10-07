package pl.writeonly.son2.vaadin.complexes

import pl.writeonly.son2.vaadin.util.UITrait

class PathComp extends ComplexWithCaption("Path") {
  val provider = new PathProviderComp
  val options = new PathOptionsComp
  val root = PathComp.horizontalLayout(provider, options)
  set(root)
}

object PathComp extends UITrait
