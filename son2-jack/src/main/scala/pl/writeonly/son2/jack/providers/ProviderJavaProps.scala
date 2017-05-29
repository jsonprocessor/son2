package pl.writeonly.son2.jack.providers

import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper
import pl.writeonly.son2.jack.core.Config

class ProviderJavaProps(config: Config) extends ProviderJack(config, new JavaPropsMapper()) {

  override def comment(s: String) = "#" + s
}
