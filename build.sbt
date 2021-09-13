name := "Unit_Integration_Testing_Assignment"

version := "0.1"

scalaVersion := "2.13.6"
val scalatest_dependency= "org.scalatest" %% "scalatest" % "3.2.2" % "test"
val mockito_dependency= "org.mockito" %% "mockito-scala" % "1.5.12" % "test"
val mockito_core_dependency= "org.mockito" % "mockito-core" % "1.9.5" % "test"
lazy val module_For_Ques1_Ques2 = project.in(file("Question1and2")).settings(
  libraryDependencies +=scalatest_dependency
)
lazy val module_For_Ques3 = project.in(file("Question3")).settings(
  libraryDependencies ++=Seq(scalatest_dependency, mockito_dependency)
)

lazy val root = project.in(file(".")).aggregate(module_For_Ques1_Ques2,module_For_Ques3)

