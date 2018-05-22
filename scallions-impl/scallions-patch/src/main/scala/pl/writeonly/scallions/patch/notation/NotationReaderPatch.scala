package pl.writeonly.scallions.patch.notation

import com.github.fge.jsonpatch.JsonPatch
import pl.writeonly.scallions.apis.config.Meta
import pl.writeonly.scallions.apis.notation.{NotationReader, Value}
import pl.writeonly.scallions.jack.notation.NotationReaderObject

class NotationReaderPatch(patch: String)
    extends NotationReader(Meta(null, null)) {

  def apply(content: String): Value = {
    val patchReader = new NotationReaderObject
    val contentReader = new NotationReaderObject
    val patchNode = patchReader.apply(patch)
    val contentNode = contentReader.apply(content)
    val patchPatch = JsonPatch.fromJson(patchNode)
    patchPatch.apply(contentNode)
  }

}
