package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.spi.json.JettisonProvider
import com.jayway.jsonpath.spi.mapper.MappingProvider
import com.jayway.jsonpath.{Configuration, TypeRef}
import pl.writeonly.son2.apis.config.{Meta, RConfig}
import pl.writeonly.son2.apis.core.Formats
import pl.writeonly.son2.path.core.{DefaultsPath, ProvidersPath}

final case class NotationCaseJettison()
    extends NotationCaseProvider(
      Meta(ProvidersPath.JETTISON, Formats.OBJECT),
      c => new DefaultsJettison(c)
    )

class DefaultsJettison(c: RConfig)
    extends DefaultsPath(c, new JettisonProvider, new JettisonMappingProvider)

class JettisonMappingProvider extends MappingProvider {
  override def map[T](source: Any,
                      targetType: Class[T],
                      configuration: Configuration) = illegalState(source)

  def illegalState(source: Any) =
    throw new IllegalStateException(s"$source")

  override def map[T](source: Any,
                      targetType: TypeRef[T],
                      configuration: Configuration) = illegalState(source)
}
