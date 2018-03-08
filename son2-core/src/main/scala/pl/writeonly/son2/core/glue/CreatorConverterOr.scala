package pl.writeonly.son2.core.glue

import org.scalactic.{Bad, ErrorMessage, Good, Or}
import pl.writeonly.son2.core.chain.{ChainNotationCreator, ChainNotationRWT}
import pl.writeonly.son2.core.config.RWTConfig
import pl.writeonly.son2.core.converters.Converter
import pl.writeonly.son2.core.pcreators.PCreatorConfig

abstract class CreatorConverterOr(parser: PCreatorConfig,
                                  rwt: ChainNotationRWT) {

  val chainNotationCreator = new ChainNotationCreator(parser, rwt)

  def converterOr(s: String): Converter Or ErrorMessage =
    configOpt(s)
      .map(c => chainNotationCreator.provider(c))
      .map(p => Good(p))
      .getOrElse(Bad(s))

  def configOpt(s: String): Option[RWTConfig] =
    chainNotationCreator.configOpt(s)
}
