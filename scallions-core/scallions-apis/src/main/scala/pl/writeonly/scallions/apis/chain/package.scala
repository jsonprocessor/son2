package pl.writeonly.scallions.apis

import pl.writeonly.scallions.apis.config.{RConfig, RWTConfig, WConfig}
import pl.writeonly.scallions.apis.notation._

package object chain {
  type PCreatorConfig = PartialFunction[String, RWTConfig]
  type PCreatorReader = PartialFunction[RConfig, NotationReader]
  type PCreatorWriter = PartialFunction[WConfig, NotationWriter]
  type PCreatorTranslator = PartialFunction[RWTConfig, NotationTranslator]
  type PCreatorNotationRWT = PartialFunction[RWTConfig, NotationRWT]

}
