package pl.writeonly.son2.jack.glue

import pl.writeonly.son2.core.glue.Streamers
import pl.writeonly.son2.core.streamers.Streamer
import pl.writeonly.son2.jack.core.Config

class Builder(config: Config) {
  def pipe: Streamer = Streamers.pipe(config.s, MatcherFormatProvider(config))

  def source: Streamer = Streamers.source(config.s, MatcherFormatProvider(config))

}




