package pl.writeonly.son2.core.file

import java.io._
import java.net.URI

import pl.writeonly.son2.core.Liner
import pl.writeonly.son2.util.Control.{toConsumerAny, using}

class StreamerImpl(son2: Liner) extends Streamer(son2) {

  override def convertFile(in: URI, out: URI): Unit = convertFile(new File(in), new File(out))

  override def convertFile(in: File, out: File): Unit = convertStream(new FileInputStream(in), new FileOutputStream(out))

  override def convertStream(in: InputStream, out: OutputStream): Unit = {
    convertNative(new InputStreamReader(in, Streamer.UTF_8), new OutputStreamWriter(out, Streamer.UTF_8))
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
