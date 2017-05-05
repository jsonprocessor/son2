package pl.writeonly.son2.core.main

import pl.writeonly.son2.core.core.Config
import pl.writeonly.son2.core.formats.MatcherFormatProvider
import pl.writeonly.son2.core.streamers._

class Builder(config: Config) {
  def impl: Streamer = Streamers.impl(config.s, MatcherFormatProvider(config))

  def source: Streamer = Streamers.source(config.s, MatcherFormatProvider(config))

}




