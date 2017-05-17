package pl.writeonly.son2.main

import pl.writeonly.son2.jack.util.AppLazyLogging

object Main extends AppLazyLogging {
  new Mainer(Params(System.in, System.out), args).either
}

