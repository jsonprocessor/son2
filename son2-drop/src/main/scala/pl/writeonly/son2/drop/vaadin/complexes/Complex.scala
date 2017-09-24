package pl.writeonly.son2.drop.vaadin.complexes

import com.vaadin.ui.{Component, Composite, CustomComponent}

abstract class Complex extends CustomComponent {

  def toComponent: Component = this
//  setCompositionRoot(toComponent)

}
