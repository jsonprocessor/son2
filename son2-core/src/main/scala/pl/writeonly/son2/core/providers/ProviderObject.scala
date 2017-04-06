package pl.writeonly.son2.core.providers

import com.fasterxml.jackson.databind.ObjectMapper

class ProviderObject(in:ObjectMapper) extends Provider(in, new ObjectMapper()) {

  override def comment(s: String) = "#" + s
}
