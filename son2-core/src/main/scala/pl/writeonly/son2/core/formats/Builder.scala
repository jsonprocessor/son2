package pl.writeonly.son2.core.formats

import pl.writeonly.son2.core.core.Config
import pl.writeonly.son2.core.streamers._

class Builder(config: Config) {
  def impl: Streamer = Streamers.impl(config.s, FormatProvider(config))

  def source: Streamer = Streamers.source(config.s, FormatProvider(config))

}




