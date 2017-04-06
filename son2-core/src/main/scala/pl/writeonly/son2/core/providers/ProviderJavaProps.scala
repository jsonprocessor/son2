package pl.writeonly.son2.core.providers

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper

class ProviderJavaProps(in:ObjectMapper) extends Provider(in, new JavaPropsMapper()) {

  override def comment(s: String) = "#" + s
}
