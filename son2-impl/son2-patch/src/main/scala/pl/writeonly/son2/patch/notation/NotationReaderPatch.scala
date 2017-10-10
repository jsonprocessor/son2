package pl.writeonly.son2.patch.notation

import com.github.fge.jsonpatch.JsonPatch
import pl.writeonly.son2.core.notation.NotationReader
import pl.writeonly.son2.jack.notation.NotationReaderObject

class NotationReaderPatch(patch:String) extends NotationReader {

  def apply(content: String): Any = {
    val patchReader = new NotationReaderObject
    val contentReader = new NotationReaderObject
    val patchNode = patchReader.apply(patch)
    val contentNode = contentReader.apply(content)
    val patchPatch = JsonPatch.fromJson(patchNode)
    patchPatch.apply(contentNode)
  }

}
