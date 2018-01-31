package pl.writeonly.son2.core.streamers

import java.io.File
import java.net.URI

import pl.writeonly.son2.core.converters.ConverterFake
import pl.writeonly.son2.spec.WhiteThrowsSpec

class StreamerSourceForeachThrowsSpec extends WhiteThrowsSpec {

  it should "produce NullPointerException when convertFile(File, File) is invoked" in {
    assertThrows[NullPointerException] {
      new StreamerSourceForeach(new ConverterFake())
        .convertFile(null.asInstanceOf[File], null.asInstanceOf[File])
    }
  }
  it should "produce NullPointerException when convertFile(URL, URL) is invoked" in {
    assertThrows[NullPointerException] {
      new StreamerSourceForeach(new ConverterFake())
        .convertFile(null.asInstanceOf[URI], null.asInstanceOf[URI])
    }
  }
  it should "produce NullPointerException when convertFile(String, String) is invoked" in {
    assertThrows[NullPointerException] {
      new StreamerSourceForeach(new ConverterFake())
        .convertFile(null.asInstanceOf[String], null.asInstanceOf[String])
    }
  }

}
