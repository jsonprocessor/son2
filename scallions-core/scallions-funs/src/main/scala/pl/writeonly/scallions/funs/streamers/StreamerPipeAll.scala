package pl.writeonly.scallions.funs.streamers

import java.io.Writer
import java.util.stream.{Collectors, Stream}

import pl.writeonly.scallions.apis.converters.Converter
import pl.writeonly.scallions.funs.liners.{Liner, LinerWithTry}
import pl.writeonly.scalaops.pipe.Pipe._

class StreamerPipeAll(liner: Liner) extends StreamerPipe(liner) {

  def this(provider: Converter) = this(new LinerWithTry(provider))

  override def stream2(stream: Stream[String], out: Writer): Unit =
    stream.collect(Collectors.joining()) |> (appendLine(out, _))

}
