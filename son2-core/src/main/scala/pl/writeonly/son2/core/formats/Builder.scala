package pl.writeonly.son2.core.formats

import pl.writeonly.son2.core.core.Config
import pl.writeonly.son2.core.liners.LinerOpt
import pl.writeonly.son2.core.streamers.{Streamer, StreamerImplAll, StreamerImplForeach}

class Builder(config: Config) {
  def impl: Streamer = if (config.s) new StreamerImplForeach(new LinerOpt(FormatProvider(config)))
  else new StreamerImplAll(new LinerOpt(FormatProvider(config)))

  def source: Streamer = if (config.s) new StreamerImplForeach(new LinerOpt(FormatProvider(config)))
  else new StreamerImplAll(new LinerOpt(FormatProvider(config)))
}
