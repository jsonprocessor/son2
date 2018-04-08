package pl.writeonly.son2.apis.chain

import pl.writeonly.son2.apis.config.{HasConfigOpt, RWTConfig}
import pl.writeonly.son2.apis.converters.{Converter, Converter1, Converter2}
import pl.writeonly.son2.apis.notation._
import pl.writeonly.son2.apis.pcreators.PCreatorConfig

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

  private def input(c: RWTConfig): NotationReaderLike =
    rwt.r
      .lift(c.read)
      .getOrElse(throw new IllegalStateException(c.read.toString))

  private def output(c: RWTConfig): NotationWriter =
    rwt.w
      .lift(c.write)
      .getOrElse(throw new IllegalStateException(c.write.toString))

  private def translator(c: RWTConfig): Option[NotationTranslator] =
    rwt.t.lift(c)

}
