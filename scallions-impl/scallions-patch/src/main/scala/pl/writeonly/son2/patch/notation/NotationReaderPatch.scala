package pl.writeonly.son2.patch.notation

import com.github.fge.jsonpatch.JsonPatch
import pl.writeonly.son2.apis.config.Meta
import pl.writeonly.son2.apis.notation.{NotationReader, Value}
import pl.writeonly.son2.jack.notation.NotationReaderObject

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
