package pl.writeonly.scallions.path

import pl.writeonly.scallions.path.notation.NotationReaderPath
import pl.writeonly.scallions.apis.config.RConfig
import pl.writeonly.scallions.path.notation.NotationReaderPath

package object core {
  type FNotationReaderPath = RConfig => NotationReaderPath
  type FDefaultsPath = RConfig => DefaultsPath
}
