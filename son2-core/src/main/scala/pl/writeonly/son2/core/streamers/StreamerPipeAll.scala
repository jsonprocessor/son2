package pl.writeonly.son2.core.streamers

import java.io.Writer
import java.util.stream.{Collectors, Stream}

import pl.writeonly.son2.core.liners.{Liner, LinerEither}
import pl.writeonly.son2.core.providers.{Provider, Provider2}

class StreamerPipeAll(liner: Liner) extends StreamerPipe(liner) {

  def this(provider: Provider) = this(new LinerEither(provider))

  override def stream2(stream: Stream[String], out: Writer): Unit = {
    val line = stream.collect(Collectors.joining())
    appendLine(out, line)
  }

}
