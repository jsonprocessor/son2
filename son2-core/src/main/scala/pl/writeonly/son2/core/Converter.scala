package pl.writeonly.son2.core

trait Converter {
  def apply(content: String): String
}