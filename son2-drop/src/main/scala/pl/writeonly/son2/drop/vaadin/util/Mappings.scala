package pl.writeonly.son2.drop.vaadin.util

import org.skyscreamer.jsonassert.JSONCompareMode

object Mappings {
  val readMapping = Map[String, Symbol](
    "All" -> 'all,
    "Line-by-line" -> 'stream
  )

  val writeMapping = Map[String, Symbol](
    "Pretty" -> 'pretty,
    "Raw" -> 'raw
  )

  val jacksonFormatsMapping = Map[String, Symbol](
    "JSON" -> 'object,
    "YAML" -> 'yaml,
    "XML" -> 'xml,
    "Java properties" -> 'properties)

  val pathProvidersMapping = Map[String, Symbol](
    "Gson" -> 'gson,
    "Jackson" -> 'object,
    "Jettison" -> 'jettison,
    "Json" -> 'json,
    "Smart" -> 'smart,
    "Strict" -> 'strict,
    "Tapestry" -> 'tapestry
  )

  val patchProviderMapping = Map[String, Symbol](
    "Gson" -> 'gson,
    "Jackson" -> 'object,
    "Smart" -> 'smart,
    "Strict" -> 'strict
  )

  val modeMapping = Map[String, JSONCompareMode](
    "Strict (extensible=false, strictOrdertrue=true)" -> JSONCompareMode.STRICT,
    "Lenient (extensible=true, strictOrder=false)" -> JSONCompareMode.LENIENT,
    "Non extensible (fextensible=alse, strictOrder=false)" -> JSONCompareMode.NON_EXTENSIBLE,
    "Strict order (extensible=true, strictOrder=true)" -> JSONCompareMode.STRICT_ORDER
  )

  val modeSymbolMapping = Map[String, Symbol](
    "Extensible" -> 'extensible,
    "Strict Order" -> 'strictOrder
  )

}
