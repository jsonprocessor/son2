package pl.writeonly.son2.core.streamers

import java.io._
import java.util.stream.Stream

import pl.writeonly.son2.liners.{Liner, LinerOpt}
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.core.util.Control.toConsumerAny

class StreamerPipeForeach(liner: Liner) extends StreamerPipe(liner) {

  def this(provider: Provider) = this(new LinerOpt(provider))

  override def stream2(stream: Stream[String], out: Writer): Unit = {
    stream.forEach { (line: String) =>
      appendLine(out, line)
    }
  }

}
