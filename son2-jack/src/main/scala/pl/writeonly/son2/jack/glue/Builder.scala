package pl.writeonly.son2.jack.glue

import pl.writeonly.son2.core.glue.Streamers
import pl.writeonly.son2.core.notation.Config
import pl.writeonly.son2.core.streamers.Streamer

class Builder(config: Config) {
  def pipe: Streamer = Streamers.pipe(config.s, ProviderCreatorJack(config))

  def source: Streamer = Streamers.source(config.s, ProviderCreatorJack(config))

}




