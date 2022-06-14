@Suppress("ReplaceJavaStaticMethodWithKotlinAnalog")
class `Fruits into baskets` {

    @Suppress("CascadeIf")

    fun totalFruit(fruits: IntArray): Int {
        if (fruits.size < 2) return fruits.size
        var l = 0
        var r = 0
        var max = 0
        val baskets = HashMap<Int, Int>()

        while (r < fruits.size) {
            val fruitType = fruits[r]
            if (baskets.size < 2) {
                // println("1")
                if (baskets[fruitType] == null) baskets[fruitType] = 0
                baskets[fruitType] = baskets[fruitType]!! + 1

            } else if (baskets.containsKey(fruitType)) {
                // println("2")
                baskets[fruitType] = baskets[fruitType]!! + 1
            } else { // new kinda fruit
                // println("3")
                while (baskets.size == 2) {
                    val fruitToRemove = fruits[l]
                    baskets[fruitToRemove] = baskets[fruitToRemove]!! - 1
                    if (baskets[fruitToRemove] == 0) baskets.remove(fruitToRemove)
                    l++
                }
                baskets[fruitType] = 1
            }
            // println("max:- $r $l")
            max = Math.max(max, (r - l + 1))
            r++
        }
        return max
    }














}