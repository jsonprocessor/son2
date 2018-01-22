package pl.writeonly.son2.core.chain

import pl.writeonly.son2.core.config.{Config, HasConfigOpt}
import pl.writeonly.son2.core.converters.{Converter, Converter1, Converter2}
import pl.writeonly.son2.core.notation._
import pl.writeonly.son2.core.pcreators.PCreatorConfig

class ChainNotationCreator(parser: PCreatorConfig, rwt: ChainNotationRWT)
    extends HasConfigOpt {

  def providerOpt(s: String): Option[Converter] = configOpt(s).map(provider)

  def configOpt(s: String): Option[Config] = parser.lift(s)

  def provider(c: Config): Converter =
    translator(c)
      .map(t => new Converter1(c, t))
      .getOrElse(new Converter2(c, input(c), output(c)))

  private def translator(c: Config): Option[NotationTranslator] = rwt.t.lift(c)

  private def input(c: Config): NotationReader =
    rwt.r
      .lift(c.read)
      .getOrElse(throw new IllegalStateException(c.read.toString))

  private def output(c: Config): NotationWriter =
    rwt.w
      .lift(c.write)
      .getOrElse(throw new IllegalStateException(c.write.toString))

}
