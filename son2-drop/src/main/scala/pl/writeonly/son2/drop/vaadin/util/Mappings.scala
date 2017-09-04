package pl.writeonly.son2.drop.vaadin.util

object Mappings {
  val readMapping = Map[String, Symbol](
    "All" -> 'all,
    "Stream" -> 'stream
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
    "Smart" -> 'smart,
    "Strict" -> 'strict
  )

  val patchProviderMapping = Map[String, Symbol](
    "Gson" -> 'gson,
    "Jackson" -> 'object,
    "Smart" -> 'smart,
    "Strict" -> 'strict
  )

}
