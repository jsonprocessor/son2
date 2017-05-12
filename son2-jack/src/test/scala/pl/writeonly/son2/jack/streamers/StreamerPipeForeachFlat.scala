package pl.writeonly.son2.jack.streamers

import java.io.File
import java.net.URI

import pl.writeonly.son2.jack.providers.ProviderFake
import pl.writeonly.son2.spec.FlatFactory

class StreamerPipeForeachFlat extends FlatFactory {

  it should "produce NullPointerException when convertFile(File, File) is invoked" in {
    assertThrows[NullPointerException] {
      new StreamerPipeForeach(new ProviderFake()).convertFile(null.asInstanceOf[File], null.asInstanceOf[File])
    }
  }
  it should "produce NullPointerException when convertFile(URL, URL) is invoked" in {
    assertThrows[NullPointerException] {
      new StreamerPipeForeach(new ProviderFake()).convertFile(null.asInstanceOf[URI], null.asInstanceOf[URI])
    }
  }
  it should "produce NullPointerException when convertFile(String, String) is invoked" in {
    assertThrows[NullPointerException] {
      new StreamerPipeForeach(new ProviderFake()).convertFile(null.asInstanceOf[String], null.asInstanceOf[String])
    }
  }

}
