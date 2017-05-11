package pl.writeonly.son2.jack.streamers

import java.io.Writer
import java.util.stream.{Collectors, Stream}

import pl.writeonly.son2.jack.liners.{Liner, LinerEither}
import pl.writeonly.son2.jack.providers.Provider

class StreamerPipeAll(liner: Liner) extends StreamerPipe(liner) {

  def this(provider: Provider) = this(new LinerEither(provider))

  override def stream2(stream: Stream[String], out: Writer): Unit = {
    val line = stream.collect(Collectors.joining())
    appendLine(out, line)
  }

}