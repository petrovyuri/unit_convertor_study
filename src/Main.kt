
import java.util.*

var inValue: Double = 0.0
lateinit var fromType: String
lateinit var toType: String
lateinit var currentFromUnit: Units
lateinit var currentToUnit: Units

fun main() {
    val scanner = Scanner(System.`in`)
    while (true) {
        print("Enter what you want to convert (or exit):")
        val input = scanner.nextLine().trim().split(" ")
        if (input[0] == "exit") break
        else {
            inValue = input[0].toDouble()
            fromType = input[1].toLowerCase()
            toType = input[3].toLowerCase()
        }
        currentFromUnit = Units.init(fromType)!!
        currentToUnit = Units.init(toType)!!
        printResult()
    }
}

private fun printResult() {
    val result = inValue * currentFromUnit.K / currentToUnit.K
    val resultFromType = if (inValue != 1.0) currentFromUnit.pluralName else currentFromUnit.singularName
    val resultToType = if (result != 1.0) currentToUnit.pluralName else currentToUnit.singularName
    println("$inValue $resultFromType is $result $resultToType")
}


