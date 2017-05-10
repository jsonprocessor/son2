package pl.writeonly.son2.jack.glue

import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.formats.MatcherFormatProvider
import pl.writeonly.son2.jack.streamers._

class Builder(config: Config) {
  def pipe: Streamer = Streamers.pipe(config.s, MatcherFormatProvider(config))

  def source: Streamer = Streamers.source(config.s, MatcherFormatProvider(config))

}




