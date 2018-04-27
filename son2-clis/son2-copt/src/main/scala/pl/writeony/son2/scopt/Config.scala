package pl.writeony.son2.scopt

import java.io.File

final case class Config(foo: Int = -1,
                        out: File = new File("."),
                        xyz: Boolean = false,
                        libName: String = "",
                        maxCount: Int = -1,
                        verbose: Boolean = false,
                        debug: Boolean = false,
                        mode: String = "",
                        files: Seq[File] = Seq.empty,
                        keepalive: Boolean = false,
                        jars: Seq[File] = Seq.empty,
                        kwargs: Map[String, String] = Map())
