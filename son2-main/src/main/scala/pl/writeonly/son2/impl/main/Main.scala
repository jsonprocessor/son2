package pl.writeonly.son2.impl.main

import pl.writeonly.son2.impl.core.providers._
import pl.writeonly.son2.core.util.AppLogging

import pl.writeonly.son2.core.Formats._

object Main extends AppLogging {

  def provider(arg:String) :Option[Provider]  = arg match {
    case o if (OBJECT.startsWith(o)) => Option(new ProviderObject)
    case y if (YAML.startsWith(y)) => Option(new ProviderYaml)
    case x if (XML.startsWith(x)) => Option(new ProviderXml)
    case c if (CSV.startsWith(c)) => Option(new ProviderCsv)
    case j if (JAVA_PROPS.startsWith(j)) => Option(new ProviderJavaProps)
    case p if (PROPERTIES.startsWith(p)) => Option(new ProviderJavaProps)
    case _ => Option.empty
  }

  val providerOpt = args.length match {
    case 0 => Option.empty
    case _ => provider(args(0).toLowerCase)
  }

  providerOpt.map { p =>
    val main = new Piper(p)
    args.length match {
      case 1 => main.convertStream();
      case 2 => main.convertFile(args(1));
      case _ => main.convertFile(args(1), args(2));
    }
  }.getOrElse {
    val main = new Piper(new ProviderImpl)
    main.convertResource("README.md")
  }
}
