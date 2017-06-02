package pl.writeonly.son2.core.json

trait JsonReader {
  def readTree(content: String) : Any
}
