package pl.writeonly.son2.apis.core

import pl.writeonly.son2.apis.config.{RConfig, WConfig}
import pl.writeonly.son2.apis.notation.{NotationReaderLike, NotationWriter}

package object core {
  type FNotationReader = RConfig => NotationReaderLike
  type FNotationWriter = WConfig => NotationWriter
  type DString = String => String
}
