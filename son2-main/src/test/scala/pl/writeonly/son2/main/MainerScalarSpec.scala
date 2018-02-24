package pl.writeonly.son2.main

import java.io.ByteArrayOutputStream

import pl.writeonly.son2.core.glue.Params
import pl.writeonly.son2.core.streamers.Streamer
import pl.writeonly.son2.spec.GrayScalarSpec

class MainerScalarSpec extends GrayScalarSpec {

  it should "when format is 'HELP ME'" in {
    val input = Streamer.toStream("")
    val output = new ByteArrayOutputStream()
    val params = Params(input, output)

    new Mainer(params, Array("HELP ME")).apply
  }
}
