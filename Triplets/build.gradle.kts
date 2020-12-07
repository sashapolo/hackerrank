plugins {
    application
}

application {
    mainClass.set("MainKt")
}

val run: JavaExec by tasks
run.standardInput = System.`in`
