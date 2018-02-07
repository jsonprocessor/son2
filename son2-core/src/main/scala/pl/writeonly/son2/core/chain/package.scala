package pl.writeonly.son2.core

import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}
import pl.writeonly.son2.core.notation.{
  NotationRWT,
  NotationReader,
  NotationTranslator,
  NotationWriter
}

package object pcreators {
  type PCreatorConfig = PartialFunction[String, Config]
  type PCreatorReader = PartialFunction[RConfig, NotationReader]
  type PCreatorWriter = PartialFunction[WConfig, NotationWriter]
  type PCreatorTranslator = PartialFunction[Config, NotationTranslator]
  type PCreatorNotationRWT = PartialFunction[Config, NotationRWT]

}
