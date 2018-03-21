package pl.writeonly.son2.path

import pl.writeonly.son2.apis.config.RConfig
import pl.writeonly.son2.path.notation.NotationReaderPath

package object core {
  type FNotationReaderPath = RConfig => NotationReaderPath
  type FDefaultsPath = RConfig => DefaultsPath
}
