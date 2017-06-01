package pl.writeonly.son2.core.json

abstract class JsonWriter(pretty: Boolean) {
  def write(value: Any):String = if (pretty) {
    writePretty(value)
  } else {
    writeRaw(value)
  }

  def writePretty(value: Any):String

  def writeRaw(value: Any):String

}
