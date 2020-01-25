package converter

import java.util.*

var inValue: Double = 0.0
lateinit var fromType: String
lateinit var toType: String
lateinit var currentFromType: Type
lateinit var currentToType: Type

data class Type(val courtName: String,
                val singularName: String,
                val pluralName: String,
                val K: Double) {

    fun findItems(value: String): Boolean {
        return value == courtName || value == singularName || value == pluralName
    }
}

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
        toConvert()
    }
}

fun toConvert() {
    addItemsInList().forEach {
        if (it.findItems(fromType)) {
            currentFromType = it
        }
        if (it.findItems(toType)) {
            currentToType = it
        }
    }
    printResult()
}

private fun printResult() {
    val result = inValue * currentFromType.K / currentToType.K
    val resultFromType = if (inValue != 1.0) currentFromType.pluralName else currentFromType.singularName
    val resultToType = if (result != 1.0) currentToType.pluralName else currentToType.singularName
    println("$inValue $resultFromType is $result $resultToType")
}

private fun addItemsInList(): List<Type> {
    val listItems = mutableListOf<Type>()
    listItems.add(Type("m", "meter", "meters", 1.0))
    listItems.add(Type("km", "kilometer", "kilometers", 1000.0))
    listItems.add(Type("cm", "centimeter", "centimeters", 0.01))
    listItems.add(Type("mm", "millimeter", "millimeters", 0.001))
    listItems.add(Type("mi", "mile", "miles", 1609.35))
    listItems.add(Type("yd", "yard", "yards", 0.9144))
    listItems.add(Type("ft", "foot", "feet", 0.3048))
    listItems.add(Type("in", "inch", "inches", 0.0254))
    listItems.add(Type("g", "gram", "grams", 1.0))
    listItems.add(Type("kg", "kilogram", "kilograms", 1000.0))
    listItems.add(Type("mg", "milligram", "milligrams", 0.001))
    listItems.add(Type("lb", "pound", "pounds", 453.592))
    listItems.add(Type("oz", "ounce", "ounces", 28.3495))
    return listItems
}



