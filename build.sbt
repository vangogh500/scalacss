name      := "ScalaCSS"
startYear := Some(2015)

// Mutability & NameGen causes occasional test failures
parallelExecution in ThisBuild := false

val root              = ScalaCssBuild.root
val rootJVM           = ScalaCssBuild.rootJVM
val rootJS            = ScalaCssBuild.rootJS

val coreJVM           = ScalaCssBuild.coreJVM
val coreJS            = ScalaCssBuild.coreJS
val elisionTestJVM    = ScalaCssBuild.elisionTestJVM
val elisionTestJS     = ScalaCssBuild.elisionTestJS
val extScalatagsJVM   = ScalaCssBuild.extScalatagsJVM
val extScalatagsJS    = ScalaCssBuild.extScalatagsJS
val extReact          = ScalaCssBuild.extReact

val bench             = BenchBuild.bench
val benchReactWithout = BenchBuild.benchReactWithout
val benchReactWith    = BenchBuild.benchReactWith
val benchBig          = BenchBuild.benchBig
