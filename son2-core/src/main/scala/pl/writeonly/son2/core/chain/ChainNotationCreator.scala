package pl.writeonly.son2.core.chain

import pl.writeonly.son2.core.config.{HasConfigOpt, RWTConfig}
import pl.writeonly.son2.core.converters.{Converter, Converter1, Converter2}
import pl.writeonly.son2.core.notation._
import pl.writeonly.son2.core.pcreators.PCreatorConfig

class ChainNotationCreator(parser: PCreatorConfig, rwt: ChainNotationRWT)
    extends HasConfigOpt {

  def providerOpt(s: String): Option[Converter] = configOpt(s).map(provider)

  def configOpt(s: String): Option[RWTConfig] = parser.lift(s)

  def provider(c: RWTConfig): Converter =
    translator(c)
      .map(t => new Converter1(c, t))
      .getOrElse(converter2(c))

  def converter2(c: RWTConfig): Converter =
    new Converter2(c, input(c), output(c))

  private def translator(c: RWTConfig): Option[NotationTranslator] =
    rwt.t.lift(c)

  private def input(c: RWTConfig): NotationReader =
    rwt.r
      .lift(c.read)
      .getOrElse(throw new IllegalStateException(c.read.toString))

  private def output(c: RWTConfig): NotationWriter =
    rwt.w
      .lift(c.write)
      .getOrElse(throw new IllegalStateException(c.write.toString))

}
