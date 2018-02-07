package pl.writeonly.son2.vaadin.util

import scala.beans.BeanProperty

case class ItemString(@BeanProperty val value: String, @BeanProperty val label: String) {

}

case class ItemSymbol(@BeanProperty val value: Symbol, @BeanProperty val label: String) extends Comparable[ItemSymbol] {
  override def compareTo(o: ItemSymbol): Int = name.compareTo(o.name)

  def name = value.name
}

object ItemSymbol {
  def apply(value: Symbol): ItemSymbol = apply(value, value.name)
}
