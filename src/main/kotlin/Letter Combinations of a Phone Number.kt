class `Letter Combinations of a Phone Number` {


    fun letterCombinations(digits: String): List<String> {
        val res = HashSet<String>()
        if (digits.isEmpty()) return emptyList()
        buildMap()
        recurse(0, HashSet(), digits)
        return res.toList()
    }

    private fun recurse(
        numbersPressedSoFar: Int,
        combinationsFormedSoFar: HashSet<String>,
        digits: String
    ) {
        if (numbersPressedSoFar == digits.length) return
        if (numbersPressedSoFar == 0) {
            val keyPressed = map[digits[0]]
            keyPressed!!.forEach {
                combinationsFormedSoFar.add(it.toString())
            }
            recurse(1, combinationsFormedSoFar, digits)
        } else {
            val keyPressed = map[digits[numbersPressedSoFar]]
            val removedStrings = ArrayList<String>()
            removedStrings.addAll(combinationsFormedSoFar)
            combinationsFormedSoFar.clear()
            keyPressed!!.forEach {  char ->
                removedStrings.forEach {  removedString ->
                    combinationsFormedSoFar.add(removedString + char)
                }
            }

            recurse(numbersPressedSoFar + 1 , combinationsFormedSoFar, digits)

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