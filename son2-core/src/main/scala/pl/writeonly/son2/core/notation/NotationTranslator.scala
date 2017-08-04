package pl.writeonly.son2.core.notation

class NotationTranslator(pretty : Boolean) extends NotationWriter(true) with NotationReader {
  override def writePretty(value: Any): String = value.asInstanceOf[String]

  override def writeRaw(value: Any): String = value.asInstanceOf[String]

  override def apply(s: String): Any = ???
}
