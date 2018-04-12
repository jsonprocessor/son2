package pl.writeonly.son2.funs.glue

import org.scalactic.{Bad, ErrorMessage, Good, Or}
import pl.writeonly.son2.apis.chain.{ChainNotationCreator, ChainNotationRWT}
import pl.writeonly.son2.apis.config.RWTConfig
import pl.writeonly.son2.apis.converters.Converter
import pl.writeonly.son2.apis.pcreators.PCreatorConfig

abstract class CreatorConverterOr(parser: PCreatorConfig,
                                  rwt: ChainNotationRWT) {

  val chainNotationCreator = new ChainNotationCreator(parser, rwt)

  def converterOr(s: String): Converter Or ErrorMessage =
    configOpt(s)
      .map(c => chainNotationCreator.provider(c))
      .getOrElse(Bad(s))

  def configOpt(s: String): Option[RWTConfig] =
    chainNotationCreator.configOpt(s)
}
