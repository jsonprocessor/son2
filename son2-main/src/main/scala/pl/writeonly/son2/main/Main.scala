package pl.writeonly.son2.main

import pl.writeonly.son2.core.providers._
import pl.writeonly.son2.util.AppLogging

object Main extends AppLogging {

  def provider(arg:String) :Option[Provider]  = arg match {
    case o if ("object".startsWith(o)) => Option(new ProviderObject)
    case y if ("yaml".startsWith(y)) => Option(new ProviderYaml)
    case x if ("xml".startsWith(x)) => Option(new ProviderXml)
    case c if ("csv".startsWith(c)) => Option(new ProviderCsv)
    case j if ("javaprops".startsWith(j)) => Option(new ProviderJavaProps)
    case p if ("properties".startsWith(p)) => Option(new ProviderJavaProps)
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
    val main = new Piper(new ProviderIdentity)
    main.convertResource("README.md")
  }
}
