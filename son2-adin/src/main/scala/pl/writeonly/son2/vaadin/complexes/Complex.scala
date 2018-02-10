package pl.writeonly.son2.vaadin.complexes

import com.vaadin.ui.{Component, CustomComponent}

abstract class Complex extends CustomComponent {

  protected def set(root: Component): Unit = {
    setCompositionRoot(root)
    setSizeUndefined
  }
}

abstract class ComplexWithCaption(caption: String) extends Complex {
  setCaption(caption)
}

trait HasRadioButtonSelectedItem {
  def selectedItem: Symbol
}

trait HasCheckBoxSelectedItem {
  def selectedItem: Set[Symbol]
}