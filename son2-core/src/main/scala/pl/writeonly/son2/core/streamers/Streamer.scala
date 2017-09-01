package pl.writeonly.son2.core.streamers

import java.io._
import java.net.URI
import java.nio.charset.StandardCharsets

import pl.writeonly.son2.core.liners.Liner

abstract class Streamer(val liner: Liner) {

  def convertFile(in: String, out: String): Unit

  def convertFile(in: URI, out: URI): Unit

  def convertFile(in: File, out: File): Unit

  def convertString(native: Boolean, in: String): String = if (native) convertStringNative(in) else convertString(in)

  def convertString(in: String): String = {
    val bytes = convertBytes(Streamer.toBytes(in))
    Streamer.toString(bytes)
  }

  def convertStringNative(in: String): String

  def convertBytes(in: Array[Byte]): Array[Byte]

  def convertStream(in: InputStream, out: OutputStream): Unit

  protected def appendLine(out: Writer, line: String): Unit = {
    val result = liner.apply(line)
    out.append(result)
  }

  protected def appendLine(out: StringBuilder, line: String): Unit = {
    val result = liner.apply(line)
    out.append(result)
  }
}

object Streamer {
  def toStream(in: String) = new ByteArrayInputStream(toBytes(in))

  def toBytes(in: String) = in.getBytes(StandardCharsets.UTF_8)

  def toString(out: ByteArrayOutputStream): String = toString(out.toByteArray)

  def toString(out: Array[Byte]): String = new String(out, StandardCharsets.UTF_8)
}
