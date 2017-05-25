package pl.writeonly.son2.main

import java.io.ByteArrayOutputStream

import pl.writeonly.son2.jack.streamers.Streamer
import pl.writeonly.son2.spec.GrayScalarSpec

class MainerScalarSpec extends GrayScalarSpec {

  describe("A Mainer") {
    val input = Streamer.toStream("")
    val output = new ByteArrayOutputStream()
    val params = Params(input, output)

    it("when format is 'HELP ME'") {
      new Mainer(params, Array("HELP ME")).either
    }

    it("when format is json and input file 'HELP ME'") {
      new Mainer(params, Array("json", "HELP ME")).either
    }

  }
}
