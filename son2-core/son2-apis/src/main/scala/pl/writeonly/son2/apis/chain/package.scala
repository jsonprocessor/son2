package pl.writeonly.son2.apis

import pl.writeonly.son2.apis.config.{RConfig, RWTConfig, WConfig}
import pl.writeonly.son2.apis.notation.{
  NotationRWT,
  NotationReader,
  NotationTranslator,
  NotationWriter
}

package object pcreators {
  type PCreatorConfig = PartialFunction[String, RWTConfig]
  type PCreatorReader = PartialFunction[RConfig, NotationReader]
  type PCreatorWriter = PartialFunction[WConfig, NotationWriter]
  type PCreatorTranslator = PartialFunction[RWTConfig, NotationTranslator]
  type PCreatorNotationRWT = PartialFunction[RWTConfig, NotationRWT]

}
