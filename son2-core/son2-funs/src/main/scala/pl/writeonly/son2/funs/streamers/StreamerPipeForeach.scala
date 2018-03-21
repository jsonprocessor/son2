package pl.writeonly.son2.funs.streamers

import java.io._
import java.util.stream.Stream

import pl.writeonly.son2.apis.converters.Converter
import pl.writeonly.son2.funs.liners.{Liner, LinerOpt}

class StreamerPipeForeach(liner: Liner) extends StreamerPipe(liner) {

  def this(provider: Converter) = this(new LinerOpt(provider))

  override def stream2(stream: Stream[String], out: Writer): Unit =
    stream.forEach { (line: String) =>
      appendLine(out, line)
    }

}
