package pl.writeonly.scallions.main

import java.io.ByteArrayOutputStream

import pl.writeonly.scallions.funs.glue.Params
import pl.writeonly.scalaops.specs.GrayScalarSpec
import pl.writeonly.scallions.funs.streamers.Streamer

class MainerScalarSpec extends GrayScalarSpec {

  it should "when format is 'HELP ME'" in {
    val input = Streamer.toStream("")
    val output = new ByteArrayOutputStream()
    val params = Params(input, output)

    new Mainer(params, Array("HELP ME")).apply
  }
}
