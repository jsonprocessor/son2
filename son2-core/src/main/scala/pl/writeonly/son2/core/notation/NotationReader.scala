package pl.writeonly.son2.core.notation

trait NotationReader {
  def apply(content: String) : Any
}
