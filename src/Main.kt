package converter

import java.lang.Exception
import java.util.*

var inValue: Double = 0.0
lateinit var fromType: String
lateinit var toType: String
lateinit var currentFromUnit: Units
lateinit var currentToUnit: Units

fun main() {
    val scanner = Scanner(System.`in`)
    while (true) {
        print("Enter what you want to convert (or exit): ")
        val input = scanner.nextLine()
        if (input.contains("exit")) break
        try {
            init(input)
            initUnits()
            checkTypes()
        } catch (e: Exception) {
            println("Parse error")
        }
    }
}

private fun init(input: String) {
    val listInput = input.trim().toLowerCase().split(Regex("\\bconvertto\\b|\\bto\\b|\\bin\\b"))
    val part1 = listInput[0].trim().split(Regex("\\s"))
    val part2 = listInput[1].trim().split(Regex("\\s"))

    if ((part1.contains("degree") || part1.contains("degrees")) && !(part2.contains("degree") || part2.contains("degrees"))) {
        inValue = part1[0].toDouble()
        fromType = """${part1[1]} ${part1[2]}"""
        toType = part2[0]
    } else if ((part2.contains("degree") || part2.contains("degrees")) && !(part1.contains("degree") || part1.contains("degrees"))) {
        inValue = part1[0].toDouble()
        fromType = part1[1]
        toType = """${part2[0]} ${part2[1]}"""
    } else if ((part1.contains("degree") || part1.contains("degrees")) && (part2.contains("degree") || part2.contains("degrees"))) {
        inValue = part1[0].toDouble()
        fromType = """${part1[1]} ${part1[2]}"""
        toType = """${part2[0]} ${part2[1]}"""
    } else {
        inValue = part1[0].toDouble()
        fromType = part1[1]
        toType = part2[0]
    }
}

private fun initUnits() {
    currentFromUnit = Units.init(fromType)!!
    currentToUnit = Units.init(toType)!!
}

private fun checkTypes() {
    if (inValue < 0 && currentFromUnit.type == Types.DISTANCE) {
        println("Length shouldn't be negative.")
    } else if (inValue < 0 && currentFromUnit.type == Types.WEIGHT) {
        println("Weight shouldn't be negative.")
    } else if ((currentFromUnit.type == currentToUnit.type) && (currentFromUnit.type != Types.NULL) && (currentToUnit.type != Types.NULL)) {
        calculationResult()
    } else {
        println("Conversion from ${currentFromUnit.pluralName} to ${currentToUnit.pluralName} is impossible")
    }
}

fun calculationResult() {
    if (currentFromUnit.type == Types.TEMP) {
        ConvertTemp().calc()
    } else {
        val result = inValue * currentFromUnit.K / currentToUnit.K
        val (resultFromType, resultToType) = pair(result)
        println("$inValue $resultFromType is $result $resultToType")
    }
}

fun pair(result: Double): Pair<String, String> {
    val resultFromType = if (inValue != 1.0) currentFromUnit.pluralName else currentFromUnit.singularName
    val resultToType = if (result != 1.0) currentToUnit.pluralName else currentToUnit.singularName
    return Pair(resultFromType, resultToType)
}





