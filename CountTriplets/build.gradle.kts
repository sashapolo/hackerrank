version = "unspecified"

plugins {
    application
}

application {
    mainClass.set("SolutionKt")
}

val run: JavaExec by tasks
run.standardInput = System.`in`
