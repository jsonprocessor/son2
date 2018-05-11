package pl.writeonly.scallions.apis

import pl.writeonly.scallions.apis.config.{RConfig, WConfig}
import pl.writeonly.scallions.apis.notation.{NotationReader, NotationWriter}

package object core {
  type FNotationReader = RConfig => NotationReader
  type FNotationWriter = WConfig => NotationWriter
  type DString = String => String
}
