package pl.writeonly.son2.drop.vaadin.util

import scala.beans.BeanProperty

case class ItemString(@BeanProperty val label: String, @BeanProperty val value: String)


case class ItemSymbol(@BeanProperty val label: String, @BeanProperty val value: Symbol)
