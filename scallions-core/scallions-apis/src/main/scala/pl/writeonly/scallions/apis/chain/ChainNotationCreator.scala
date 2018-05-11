package pl.writeonly.scallions.apis.chain

import org.scalactic.{Bad, Good, Or}
import pl.writeonly.scallions.apis.config.HasConfigOpt
import pl.writeonly.scallions.apis.config.RWTConfig
import pl.writeonly.scallions.apis.converters.{Converter, Converter1, Converter2}
import pl.writeonly.scallions.apis.notation._
import pl.writeonly.scallions.apis.chain.PCreatorConfig

class ChainNotationCreator(parser: PCreatorConfig, rwt: ChainNotationRWT)
    extends HasConfigOpt {

  def providerOpt(s: String): Option[Converter Or String] =
    configOpt(s).map(provider)

  def configOpt(s: String): Option[RWTConfig] = parser.lift(s)

  def provider(c: RWTConfig): Converter Or String =
    translator(c)
      .map(t => new Converter1(c, t))
      .map(Good(_))
      .getOrElse(converter2(c))

  def converter2(c: RWTConfig): Converter Or String =
    for {
      i <- input(c)
      o <- output(c)
    } yield new Converter2(c, i, o)

  private def input(c: RWTConfig): NotationReader Or String =
    rwt.r
      .lift(c.read)
      .map(Good(_))
      .getOrElse(Bad(c.read.toString))

  private def output(c: RWTConfig): NotationWriter Or String =
    rwt.w
      .lift(c.write)
      .map(Good(_))
      .getOrElse(Bad(c.write.toString))

  private def translator(c: RWTConfig): Option[NotationTranslator] =
    rwt.t.lift(c)

}
