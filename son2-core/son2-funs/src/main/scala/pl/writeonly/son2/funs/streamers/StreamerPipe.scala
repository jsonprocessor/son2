package pl.writeonly.son2.funs.streamers

import java.io._
import java.net.URI
import java.util.stream.Stream

import pl.writeonly.son2.funs.liners.Liner
import pl.writeonly.addons.ops.AutoCloseableOps
import pl.writeonly.addons.ops.AutoCloseableOps.using

abstract class StreamerPipe(liner: Liner) extends Streamer(liner) {

  override def convertFile(in: String, out: String): Unit =
    convertFile(new File(in), new File(out))

  override def convertFile(in: File, out: File): Unit =
    convertStream(new FileInputStream(in), new FileOutputStream(out))

  override def convertFile(in: URI, out: URI): Unit =
    convertFile(new File(in), new File(out))

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

  override def convertStream(in: InputStream, out: OutputStream): Unit =
    convertNative(
      new InputStreamReader(in, AutoCloseableOps.UTF_8),
      new OutputStreamWriter(out, AutoCloseableOps.UTF_8)
    )

  def convertNative(in: Reader, out: Writer): Unit =
    using(new BufferedWriter(out)) { bw =>
      using(new BufferedReader(in)) { br =>
        convertBuffered(br, bw)
      }
    }

  def convertBuffered(in: BufferedReader, out: BufferedWriter): Unit =
    stream2(in.lines(), out)

  def stream2(stream: Stream[String], out: Writer): Unit

}
