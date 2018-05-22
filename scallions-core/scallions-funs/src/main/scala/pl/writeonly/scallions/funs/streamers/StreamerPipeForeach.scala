package pl.writeonly.scallions.funs.streamers

import java.io._
import java.util.stream.Stream

import pl.writeonly.scallions.apis.converters.Converter
import pl.writeonly.scallions.funs.liners.{Liner, LinerOpt}

class StreamerPipeForeach(liner: Liner) extends StreamerPipe(liner) {

  def this(provider: Converter) = this(new LinerOpt(provider))

  override def stream2(stream: Stream[String], out: Writer): Unit =
    stream.forEach { (line: String) =>
      appendLine(out, line)
    }

}
