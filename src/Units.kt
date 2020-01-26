package converter

enum class Units(
        val longSingularName: String,
        val longPluralName: String,
        val courtName: String,
        val singularName: String,
        val pluralName: String,
        val K: Double,
        val type: Types) {
    METER("", "", "m", "meter", "meters", 1.0, Types.DISTANCE),
    KILOMETR("", "", "km", "kilometer", "kilometers", 1000.0, Types.DISTANCE),
    CENTIMETR("", "", "cm", "centimeter", "centimeters", 0.01, Types.DISTANCE),
    MILLIMETR("", "", "mm", "millimeter", "millimeters", 0.001, Types.DISTANCE),
    MILE("", "", "mi", "mile", "miles", 1609.35, Types.DISTANCE),
    YARD("", "", "yd", "yard", "yards", 0.9144, Types.DISTANCE),
    FOOT("", "", "ft", "foot", "feet", 0.3048, Types.DISTANCE),
    INCH("", "", "in", "inch", "inches", 0.0254, Types.DISTANCE),
    GRAM("", "", "g", "gram", "grams", 1.0, Types.WEIGHT),
    KILOGRAM("", "", "kg", "kilogram", "kilograms", 1000.0, Types.WEIGHT),
    MILIGRAM("", "", "mg", "milligram", "milligrams", 0.001, Types.WEIGHT),
    POUND("", "", "lb", "pound", "pounds", 453.592, Types.WEIGHT),
    OUNCE("", "", "oz", "ounce", "ounces", 28.3495, Types.WEIGHT),
    CELSIUS("celsius", "dc", "c", "degree Celsius", "degrees Celsius", 0.0, Types.TEMP),
    FAHRENHEIT("fahrenheit", "df", "f", "degree Fahrenheit", "degrees Fahrenheit", 0.0, Types.TEMP),
    KELVIN("", "", "k", "Kelvin", "Kelvins", 0.0, Types.TEMP),
    NULL("","","","","???",0.0,Types.NULL);

    companion object {
        fun init(string: String): Units? {
            return values().find {
                it.courtName == string
                        || it.singularName.toLowerCase() == string
                        || it.pluralName.toLowerCase() == string
                        || it.longPluralName == string
                        || it.longSingularName == string
            }?:NULL
        }
    }

}
