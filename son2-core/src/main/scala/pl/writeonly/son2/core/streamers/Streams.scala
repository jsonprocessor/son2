package pl.writeonly.son2.core.streamers

import pl.writeonly.son2.core.liners.{LinerEitherException, LinerOpt}
import pl.writeonly.son2.core.providers.Provider

object Streams {
  def impl(s: Boolean, provider: Provider): Streamer = if (s) new StreamerImplForeach(new LinerOpt(provider))
  else new StreamerImplAll(new LinerEitherException(provider))

  def source(s: Boolean, provider: Provider): Streamer = if (s) new StreamerSourceForeach(new LinerOpt(provider))
  else new StreamerSourceAll(new LinerEitherException(provider))
}
