package pl.writeonly.son2.path

import pl.writeonly.son2.core.config.RConfig
import pl.writeonly.son2.path.core.DefaultsPath
import pl.writeonly.son2.path.notation.NotationReaderPath

package object core {
  type FNotationReaderPath = RConfig => NotationReaderPath
  type FDefaultsPath = RConfig => DefaultsPath
}
