package pl.writeonly.scallions.apis.converters

import org.scalactic.{Bad, Or}
import pl.writeonly.scallions.apis.config.{Format, ProviderType}
import pl.writeonly.scallions.apis.chain._
import pl.writeonly.scallions.apis.config.{Format, RWTConfig}

class CreatorConverter(creator: ChainNotationConfig, rwt: ChainNotationRWT) {
  def apply(s: ProviderType): Converter Or String =
    new ChainNotationCreator(creator.get, rwt)
      .providerOpt(s.name)
      .getOrElse(Bad(s"$s"))

  def apply(s: Format): Converter Or String =
    new ChainNotationCreator(creator.get, rwt)
      .providerOpt(s.name)
      .getOrElse(Bad(s"$s"))

  def apply(c: RWTConfig): Converter Or String =
    new ChainNotationCreator(creator.get, rwt)
      .provider(c)
}
