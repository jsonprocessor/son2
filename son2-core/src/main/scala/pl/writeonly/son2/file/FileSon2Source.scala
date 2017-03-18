package pl.writeonly.son2.file

import java.io.{File, InputStream, OutputStream, PrintWriter}
import java.net.URI

import pl.writeonly.son2.core.Son2
import pl.writeonly.son2.util.Control.using

import scala.io.Source

class FileSon2Source(onml: Son2) extends FileSon2(onml) {

  def convertStringNative(in:String):String = {
    val sb = new StringBuilder()
    Source.fromString(in).getLines().foreach { line =>
      appendLine(sb, line)
    }
    sb.toString
  }

  override def convertBytes(in: Array[Byte]): Array[Byte] = {
    val sb = new StringBuilder()
    Source.fromRawBytes(in).getLines().foreach { line =>
      appendLine(sb, line)
    }
    sb.toString.getBytes
  }

  override def convertFile(in: URI, out: URI): Unit = {
    using(new PrintWriter(new File(out))) { pw =>
      using(Source.fromURI(in)) { source =>
        source.getLines().foreach { line =>
          appendLine(pw, line)
        }
      }
    }
  }

  override def convertFile(in: File, out: File): Unit = {
    using(new PrintWriter(out)) { pw =>
      using(Source.fromFile(in)) { source =>
        source.getLines().foreach { line =>
          appendLine(pw, line)
        }
      }
    }
  }

  override def convertStream(in: InputStream, out: OutputStream): Unit = {
    using(new PrintWriter(out)) { pw =>
      using(Source.fromInputStream(in, FileSon2.UTF_8)) { source =>
        source.getLines().foreach { line =>
          appendLine(pw, line)
        }
      }
    }
  }
}