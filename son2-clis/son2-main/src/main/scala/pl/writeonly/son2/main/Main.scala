package pl.writeonly.son2.main

import pl.writeonly.son2.funs.glue.Params

object Main extends AppLazyLogging {
  new Mainer(Params(System.in, System.out), args, new CreatorConverterOrMain()).apply
}
