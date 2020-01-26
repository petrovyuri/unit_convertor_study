enum class Units(val courtName: String,
                 val singularName: String,
                 val pluralName: String,
                 val K: Double) {
    METER("m", "meter", "meters", 1.0),
    KILOMETR("km", "kilometer", "kilometers", 1000.0),
    CENTIMETR("cm", "centimeter", "centimeters", 0.01),
    MILLIMETR("mm", "millimeter", "millimeters", 0.001),
    MILE("mi", "mile", "miles", 1609.35),
    YARD("yd", "yard", "yards", 0.9144),
    FOOT("ft", "foot", "feet", 0.3048),
    INCH("in", "inch", "inches", 0.0254),
    GRAM("g", "gram", "grams", 1.0),
    KILOGRAM("kg", "kilogram", "kilograms", 1000.0),
    MILIGRAM("mg", "milligram", "milligrams", 0.001),
    POUND("lb", "pound", "pounds", 453.592),
    OUNCE("oz", "ounce", "ounces", 28.3495);

    companion object {
        fun init(string: String): Units? {
            return values().find { it.courtName == string || it.singularName == string || it.pluralName == string }
        }
    }
}
