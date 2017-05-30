package pl.writeonly.son2.core.glue

import pl.writeonly.son2.liners.{LinerEither, LinerOpt}
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.core.streamers._

object Streamers {
  def pipe(s: Boolean, provider: Provider): Streamer = if (s) new StreamerPipeForeach(new LinerOpt(provider))
  else new StreamerPipeAll(new LinerEither(provider))

  def source(s: Boolean, provider: Provider): Streamer = if (s) new StreamerSourceForeach(new LinerOpt(provider))
  else new StreamerSourceAll(new LinerEither(provider))
}
