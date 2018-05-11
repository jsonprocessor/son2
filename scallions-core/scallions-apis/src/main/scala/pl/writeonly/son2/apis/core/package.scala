package pl.writeonly.son2.apis.core

import pl.writeonly.son2.apis.config.{RConfig, WConfig}
import pl.writeonly.son2.apis.notation.{NotationReader, NotationWriter}

package object core {
  type FNotationReader = RConfig => NotationReader
  type FNotationWriter = WConfig => NotationWriter
  type DString = String => String
}
