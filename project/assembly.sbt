//resolvers += Resolver.url("bintray-sbt-plugins", url("https://dl.bintray.com/eed3si9n/sbt-plugins/"))(Resolver.ivyStylePatterns)
resolvers += Resolver.url("bintray-sbt-plugins", url("http://dl.bintray.com/sbt/sbt-plugin-releases"))(Resolver.ivyStylePatterns)

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.5")
addSbtPlugin("com.github.sbt" % "sbt-jacoco" % "3.0.3")
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1")
//addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.1.0")