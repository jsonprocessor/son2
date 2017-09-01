package pl.writeonly.son2.core.streamers

import java.io.Writer
import java.util.stream.{Collectors, Stream}

import pl.writeonly.son2.core.converters.Converter
import pl.writeonly.son2.core.liners.{Liner, LinerEither}

class StreamerPipeAll(liner: Liner) extends StreamerPipe(liner) {

  def this(provider: Converter) = this(new LinerEither(provider))

  override def stream2(stream: Stream[String], out: Writer): Unit = {
    val line = stream.collect(Collectors.joining())
    appendLine(out, line)
  }

}
