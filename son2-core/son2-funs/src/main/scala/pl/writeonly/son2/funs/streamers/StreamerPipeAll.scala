package pl.writeonly.son2.funs.streamers

import java.io.Writer
import java.util.stream.{Collectors, Stream}

import pl.writeonly.son2.apis.converters.Converter
import pl.writeonly.son2.funs.liners.{Liner, LinerWithTry}
import pl.writeonly.sons.utils.ops.Pipe._

class StreamerPipeAll(liner: Liner) extends StreamerPipe(liner) {

  def this(provider: Converter) = this(new LinerWithTry(provider))

  override def stream2(stream: Stream[String], out: Writer): Unit =
    stream.collect(Collectors.joining()) |> (appendLine(out, _))

}
