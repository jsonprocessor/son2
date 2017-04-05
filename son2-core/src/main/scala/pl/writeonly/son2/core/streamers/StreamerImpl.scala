package pl.writeonly.son2.core.streamers

import java.io._
import java.net.URI

import pl.writeonly.son2.core.liners.{Liner, LinerOpt}
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.core.util.Control
import pl.writeonly.son2.core.util.Control.{toConsumerAny, using}


class StreamerImpl(liner: Liner) extends Streamer(liner) {

  def this(provider : Provider) = this(new LinerOpt(provider))

  override def convertFile(in: URI, out: URI): Unit = convertFile(new File(in), new File(out))

  override def convertFile(in: File, out: File): Unit = convertStream(new FileInputStream(in), new FileOutputStream(out))

  override def convertStream(in: InputStream, out: OutputStream): Unit = {
    convertNative(new InputStreamReader(in, Control.UTF_8), new OutputStreamWriter(out, Control.UTF_8))
  }

  def convertNative(in: Reader, out: Writer): Unit = {
    using(new BufferedWriter(out)) { bw =>
      using(new BufferedReader(in)) { br =>
        convertBuffered(br, bw)
      }
    }
  }

  def convertBuffered(in: BufferedReader, out: BufferedWriter): Unit = {
    in.lines().forEach { (line: String) =>
      appendLine(out, line)
    }
  }

  override def convertStringNative(in: String): String = {
    val out = new StringWriter()
    convertNative(new StringReader(in), out)
    out.toString
  }

  override def convertBytes(in: Array[Byte]): Array[Byte] = {
    val out = new ByteArrayOutputStream()
    convertStream(new ByteArrayInputStream(in), out)
    out.toByteArray
  }
}
