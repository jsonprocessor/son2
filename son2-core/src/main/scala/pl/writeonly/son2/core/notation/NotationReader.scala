package pl.writeonly.son2.core.notation

trait NotationReader {
  def readTree(content: String) : Any
}
