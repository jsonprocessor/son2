package pl.writeonly.son2.core.json

abstract class JsonWriter(pretty: Boolean) {
  def write(value: Any) = if (pretty) {
    writePretty(value)
  } else {
    writeRaw(value)
  }

  def writePretty(value: Any)

  def writeRaw(value: Any)

}
