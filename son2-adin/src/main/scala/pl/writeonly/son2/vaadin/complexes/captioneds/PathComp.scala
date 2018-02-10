package pl.writeonly.son2.vaadin.complexes.captioneds

import pl.writeonly.son2.vaadin.complexes.ComplexWithCaption
import pl.writeonly.son2.vaadin.complexes.hasselecteditems.{PathOptionsComp, PathProviderComp}
import pl.writeonly.son2.vaadin.util.UIUtil

class PathComp extends ComplexWithCaption("Path") {
  val provider = new PathProviderComp
  val options = new PathOptionsComp
  val root = PathComp.horizontalLayout(provider, options)
  set(root)
}

object PathComp extends UIUtil
