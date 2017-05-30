package pl.writeonly.son2.core.converters

trait Converter {
  def apply(content: String): String
}