
sbtPlugin := true

organization := "com.typesafe.sbt"

name := "sbt-aspectj"

version := "0.8.0-SNAPSHOT"

libraryDependencies += "org.aspectj" % "aspectjtools" % "1.7.1"

publishMavenStyle := false

publishTo <<= (version) { v =>
  def scalasbt(repo: String) = ("scalasbt " + repo, "http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-" + repo)
  val (name, repo) = if (v.endsWith("-SNAPSHOT")) scalasbt("snapshots") else scalasbt("releases")
  Some(Resolver.url(name, url(repo))(Resolver.ivyStylePatterns))
}
