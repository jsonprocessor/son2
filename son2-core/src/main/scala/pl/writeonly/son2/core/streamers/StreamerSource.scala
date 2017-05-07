package pl.writeonly.son2.core.streamers

import java.io.{File, InputStream, OutputStream, PrintWriter}
import java.net.URI

import pl.writeonly.son2.core.liners.{Liner, LinerOpt}
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.core.util.Control
import pl.writeonly.son2.core.util.Control.using

import scala.io.Source

abstract class StreamerSource(liner: Liner) extends Streamer(liner) {

  def convertStringNative(in: String): String = source2string(Source.fromString(in))

  override def convertBytes(in: Array[Byte]): Array[Byte] = source2string(Source.fromRawBytes(in)).getBytes

  override def convertFile(in: URI, out: URI): Unit = {
    using(Source.fromURI(in)) { source =>
      using(new PrintWriter(new File(out))) { pw =>
        source2pw(source, pw)
      }
    }
  }

  override def convertFile(in: File, out: File): Unit = {
    using(Source.fromFile(in)) { source =>
      using(new PrintWriter(out)) { pw =>
        source2pw(source, pw)
      }
    }
  }

  override def convertStream(in: InputStream, out: OutputStream): Unit = {
    using(Source.fromInputStream(in, Control.UTF_8)) { source =>
      using(new PrintWriter(out)) { pw =>
        source2pw(source, pw)
      }
    }
  }

  def source2string(source: Source): String

  def source2pw(source: Source, pw: PrintWriter): Unit
}