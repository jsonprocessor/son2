package pl.writeonly.son2.core.formats

import pl.writeonly.son2.core.core.Config
import pl.writeonly.son2.core.streamers._

class Builder(config: Config) {
  def impl: Streamer = Streams.impl(config.s, FormatProvider(config))

  def source: Streamer = Streams.source(config.s, FormatProvider(config))

}




