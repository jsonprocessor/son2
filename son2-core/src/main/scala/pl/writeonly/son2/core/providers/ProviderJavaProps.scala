package pl.writeonly.son2.core.providers

import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper
import pl.writeonly.son2.core.core.Config

class ProviderJavaProps(config: Config) extends Provider(config, new JavaPropsMapper()) {

  override def comment(s: String) = "#" + s
}
