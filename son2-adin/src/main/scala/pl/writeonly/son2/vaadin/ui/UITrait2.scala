package pl.writeonly.son2.vaadin.ui

import pl.writeonly.son2.vaadin.util.UITrait

trait UITrait2 extends UITrait {

  override def componentsCenter = componentsCenter2.list

  def componentsCenter2 : Components
}
