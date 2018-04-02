package pl.writeonly.son2.hocon

import pl.writeonly.son2.funs.glue.Params
import pl.writeonly.son2.main.{AppLazyLogging, Mainer}

object Hocon extends AppLazyLogging {
  new Mainer(Params(System.in, System.out), args, new CreatorConverterOrHocon).apply
}
