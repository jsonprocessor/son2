package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.{Configuration, JsonPath}
import pl.writeonly.son2.core.notation.NotationReader

class NotationReaderPath(val path: String) extends NotationReader {

  def apply(content: String):Any = JsonPath
    .using(configuration)
    .parse(content)
    .read(path)

  def configuration = Configuration.defaultConfiguration()

}
