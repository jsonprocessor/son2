package pl.writeonly.son2.core

import pl.writeonly.son2.core.config.{RConfig, WConfig}
import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter}

package object core {
  type FNotationReader = RConfig => NotationReader
  type FNotationWriter = WConfig => NotationWriter
  type DString = String => String
}
