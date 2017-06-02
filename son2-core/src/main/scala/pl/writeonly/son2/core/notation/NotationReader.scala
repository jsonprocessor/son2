package pl.writeonly.son2.core.notation

trait JsonReader {
  def readTree(content: String) : Any
}
