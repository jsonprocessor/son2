package pl.writeonly.son2.drop.vaadin.complexes

import com.vaadin.ui.{Component, Composite}

abstract class Complex extends Composite {

  def toComponent: Component

}
