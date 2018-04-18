package pl.writeonly.son2.funs.glue

import pl.writeonly.son2.apis.config.RStyle
import pl.writeonly.son2.apis.config.RStyle.{RAll, RStream}
import pl.writeonly.son2.apis.converters.Converter
import pl.writeonly.son2.funs.liners.{LinerOpt, LinerWithTry}
import pl.writeonly.son2.funs.streamers._

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
