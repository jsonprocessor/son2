package pl.writeonly.son2.jack.glue

import pl.writeonly.son2.core.glue.{Config, Streamers}
import pl.writeonly.son2.core.streamers.Streamer

class Builder(config: Config) {
  def pipe: Streamer = Streamers.pipe(config.s, MatcherFormatProviderJack(config))

  def source: Streamer = Streamers.source(config.s, MatcherFormatProviderJack(config))

}




