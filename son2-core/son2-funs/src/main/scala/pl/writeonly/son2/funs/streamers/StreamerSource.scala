package pl.writeonly.son2.funs.streamers

import java.io.{File, InputStream, OutputStream, PrintWriter}
import java.net.URI

import pl.writeonly.son2.funs.liners.Liner
import pl.writeonly.scalaops.ops.AutoCloseableOps
import pl.writeonly.scalaops.ops.AutoCloseableOps.using

import scala.io.Source

abstract class StreamerSource(liner: Liner) extends Streamer(liner) {

  def convertStringNative(in: String): String =
    source2string(Source.fromString(in))

  override def convertBytes(in: Array[Byte]): Array[Byte] =
    source2string(Source.fromRawBytes(in)).getBytes

  def source2string(source: Source): String = {
    import java.lang.{StringBuilder => JavaStringBuilder}
    val sb = new JavaStringBuilder()
    source2pw(source, sb)
    sb.toString
  }

  override def convertFile(in: String, out: String): Unit =
    using(Source.fromFile(in))(s => source2pw(s, new File(out)))

  override def convertFile(in: URI, out: URI): Unit =
    using(Source.fromFile(in))(s => source2pw(s, new File(out)))

  def source2pw(source: Source, out: File): Unit =
    using(new PrintWriter(out))(pw => source2pw(source, pw))

  override def convertFile(in: File, out: File): Unit =
    using(Source.fromFile(in))(s => source2pw(s, out))

  override def convertStream(in: InputStream, out: OutputStream): Unit =
    using(Source.fromInputStream(in, AutoCloseableOps.UTF_8)) { source =>
      using(new PrintWriter(out)) { pw =>
        source2pw(source, pw)
      }
    }

  def source2pw(source: Source, pw: Appendable): Unit
}
