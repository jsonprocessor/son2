package pl.writeonly.son2.core.glue

import pl.writeonly.son2.core.liners.{LinerEither, LinerOpt}
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.core.streamers._

object Streamers {
  def print(native:Boolean, s: Boolean, p: Provider) = if (native) source(s, p) else pipe(s,p)


  def pipe(s: Boolean, p: Provider): Streamer = if (s) new StreamerPipeForeach(new LinerOpt(p))
  else new StreamerPipeAll(new LinerEither(p))

  def source(s: Boolean, p: Provider): Streamer = if (s) new StreamerSourceForeach(new LinerOpt(p))
  else new StreamerSourceAll(new LinerEither(p))
}
