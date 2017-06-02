package pl.writeonly.son2.core.notation

class JsonWriter(pretty: Boolean) {
  def write(value: Any):String = if (pretty) {
    writePretty(value)
  } else {
    writeRaw(value)
  }

  def writePretty(value: Any):String = value.toString()

  def writeRaw(value: Any):String = value.toString()

  def comment(s: String) = s
}
