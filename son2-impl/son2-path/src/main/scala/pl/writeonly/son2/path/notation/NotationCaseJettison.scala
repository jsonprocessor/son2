package pl.writeonly.son2.path.notation

import java.util.Objects

import com.jayway.jsonpath.spi.json.JettisonProvider
import com.jayway.jsonpath.spi.mapper.MappingProvider
import com.jayway.jsonpath.{Configuration, TypeRef}
import pl.writeonly.son2.core.config.RConfig
import pl.writeonly.son2.path.core.{DefaultsPath, ProvidersPath}

case class NotationCaseJettison()
    extends NotationCaseProvider(ProvidersPath.JETTISON,
                                 c => new DefaultsJettison(c))

class DefaultsJettison(c: RConfig)
    extends DefaultsPath(c, new JettisonProvider, new JettisonMappingProvider)

class JettisonMappingProvider extends MappingProvider {
  override def map[T](source: Any,
                      targetType: Class[T],
                      configuration: Configuration) = illegalState(source)

  override def map[T](source: Any,
                      targetType: TypeRef[T],
                      configuration: Configuration) = illegalState(source)

  def illegalState(source: Any) =
    throw new IllegalStateException(Objects.toString(source))
}
