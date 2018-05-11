package pl.writeonly.scallions.funs.glue

import org.scalactic.{Bad, ErrorMessage, Or}
import pl.writeonly.scallions.apis.chain.{ChainNotationCreator, ChainNotationRWT}
import pl.writeonly.scallions.apis.config.RWTConfig
import pl.writeonly.scallions.apis.converters.Converter
import pl.writeonly.scallions.apis.chain.PCreatorConfig

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
