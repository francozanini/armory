package io.fz.armory

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ArmoryApplication

fun main(args: Array<String>) {
    runApplication<ArmoryApplication>(*args)
}
