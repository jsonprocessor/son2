package pl.writeonly.son2.drop.vaadin.complexes

import com.vaadin.ui.{Component, CustomComponent}

abstract class Complex extends CustomComponent {


  protected def set(root : Component): Unit = {
    setCompositionRoot(root)
    setSizeUndefined
  }
}
