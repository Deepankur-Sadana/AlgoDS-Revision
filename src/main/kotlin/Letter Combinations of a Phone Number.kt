import java.lang.StringBuilder

class `Letter Combinations of a Phone Number` {

    val res = ArrayList<String>()
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        buildMap()
        recurse(0, StringBuilder(), digits)
        return res.toList()
    }

    private fun recurse(
        numbersPressedSoFar: Int,
        stringFormedSoFar: StringBuilder,
        digits: String
    ) {
        if (numbersPressedSoFar == digits.length) {
            res.add(stringFormedSoFar.toString())
            return
        }
        if (numbersPressedSoFar == 0) {
            val keyPressed = map[digits[0]]
            keyPressed!!.forEach {
                recurse(1, StringBuilder(it.toString()), digits)
            }
        } else {
            val keyPressed = map[digits[numbersPressedSoFar]]
            keyPressed!!.forEach {  char ->
                val sb = StringBuilder()
                sb.append(stringFormedSoFar)
                sb.append(char)
                recurse(numbersPressedSoFar + 1, sb, digits)
            }
        }
    }





    private val map = HashMap<Char, String>()

    private fun buildMap(): HashMap<Char, String> {
        map['2'] = "abc"
        map['3'] = "def"
        map['4'] = "ghi"
        map['5'] = "jkl"
        map['6'] = "mno"
        map['7'] = "pqrs"
        map['8'] = "tuv"
        map['9'] = "wxyz"

        return map
    }
}