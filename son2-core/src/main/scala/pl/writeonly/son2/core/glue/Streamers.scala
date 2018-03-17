package pl.writeonly.son2.core.glue

import pl.writeonly.son2.core.config.{RAll, RStream, RStyle}
import pl.writeonly.son2.core.converters.Converter
import pl.writeonly.son2.core.liners.{LinerWithTry, LinerOpt}
import pl.writeonly.son2.core.streamers._

object Streamers {
  def print(native: Boolean, s: RStyle, p: Converter): Streamer =
    if (native) source(s, p) else pipe(s, p)

  def pipe(s: RStyle, p: Converter): Streamer = s match {
    case RStream => new StreamerPipeForeach(new LinerOpt(p))
    case RAll    => new StreamerPipeAll(new LinerWithTry(p))
  }

  def source(s: RStyle, p: Converter): Streamer = s match {
    case RStream => new StreamerSourceForeach(new LinerOpt(p))
    case RAll    => new StreamerSourceAll(new LinerWithTry(p))
  }
}
