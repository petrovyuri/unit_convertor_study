package converter

class ConvertTemp {

    fun calc() {
        when (currentToUnit.name) {
            "CELSIUS" -> calcCelsius()
            "FAHRENHEIT" -> calcFahrenheit()
            "KELVIN" -> calcKelvin()
        }
    }

    private fun calcKelvin() {
        if (currentFromUnit.name == "CELSIUS") {
            val result = inValue + 273.15
            val (resultFromType, resultToType) = pair(result)
            println("$inValue $resultFromType is $result $resultToType")
        } else if (currentFromUnit.name == "FAHRENHEIT") {
            val result = (inValue + 459.67) * 5 / 9
            val (resultFromType, resultToType) = pair(result)
            println("$inValue $resultFromType is $result $resultToType")
        } else {
            val result = inValue
            val (resultFromType, resultToType) = pair(result)
            println("$inValue $resultFromType is $result $resultToType")
        }
    }

    private fun calcFahrenheit() {
        if (currentFromUnit.name == "CELSIUS") {
            val result = inValue * 9 / 5 + 32
            val (resultFromType, resultToType) = pair(result)
            println("$inValue $resultFromType is $result $resultToType")
        } else if(currentFromUnit.name == "KELVIN") {
            val result = (inValue * 9 / 5) - 459.67
            val (resultFromType, resultToType) = pair(result)
            println("$inValue $resultFromType is $result $resultToType")
        }else{
            val result = inValue
            val (resultFromType, resultToType) = pair(result)
            println("$inValue $resultFromType is $result $resultToType")
        }
    }

    private fun calcCelsius() {
        if (currentFromUnit.name == "KELVIN") {
            val result = inValue - 273.15
            val (resultFromType, resultToType) = pair(result)
            println("$inValue $resultFromType is $result $resultToType")
        } else if (currentFromUnit.name == "FAHRENHEIT") {
            val result = (inValue - 32) * 5 / 9
            val (resultFromType, resultToType) = pair(result)
            println("$inValue $resultFromType is $result $resultToType")
        } else {
            val result = inValue
            val (resultFromType, resultToType) = pair(result)
            println("$inValue $resultFromType is $result $resultToType")
        }
    }
}