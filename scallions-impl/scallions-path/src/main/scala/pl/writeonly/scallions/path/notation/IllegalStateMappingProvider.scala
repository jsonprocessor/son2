package pl.writeonly.scallions.path.notation

import com.jayway.jsonpath.spi.mapper.MappingProvider
import com.jayway.jsonpath.{Configuration, TypeRef}

class IllegalStateMappingProvider extends MappingProvider {
  override def map[T](source: Any,
                      targetType: Class[T],
                      configuration: Configuration): T = illegalState(source)

  def illegalState(source: Any) =
    throw new IllegalStateException(s"$source")

  override def map[T](source: Any,
                      targetType: TypeRef[T],
                      configuration: Configuration): T = illegalState(source)
}
