package pl.writeonly.son2.core.chain

import pl.writeonly.son2.core.config.{Config, HasConfigOpt}
import pl.writeonly.son2.core.notation._
import pl.writeonly.son2.core.pcreators.PCreatorConfig
import pl.writeonly.son2.core.providers.{Provider, Provider1, Provider2}

class ChainNotationCreator(parser: PCreatorConfig, rwt: ChainNotationRWT)
  extends HasConfigOpt {

  def providerOpt(s: String): Option[Provider] = configOpt(s).map(provider)

  def configOpt(s: String): Option[Config] = parser.lift(s)

  def provider(c: Config): Provider = translator(c)
    .map(t => new Provider1(c, t))
    .getOrElse(new Provider2(c, input(c), output(c)))

  private def translator(c: Config): Option[NotationTranslator] = rwt.t.lift(c)

  private def input(c: Config): NotationReader = rwt.r.lift(c.read).get

  private def output(c: Config): NotationWriter = rwt.w.lift(c.write).get
}
