package pl.writeonly.son2.impl.core.providers

import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper

class ProviderJavaProps() extends Provider(new JavaPropsMapper()) {

  override def comment(s: String) = "#" + s
}
