package pl.writeonly.son2.jack.glue

import pl.writeonly.son2.jack.liners.{LinerEither, LinerOpt}
import pl.writeonly.son2.jack.providers.Provider
import pl.writeonly.son2.jack.streamers._

object Streamers {
  def impl(s: Boolean, provider: Provider): Streamer = if (s) new StreamerImplForeach(new LinerOpt(provider))
  else new StreamerImplAll(new LinerEither(provider))

  def source(s: Boolean, provider: Provider): Streamer = if (s) new StreamerSourceForeach(new LinerOpt(provider))
  else new StreamerSourceAll(new LinerEither(provider))
}
