class `Best Time to Buy and Sell Stock II` {

    fun maxProfit(prices: IntArray): Int {
        if (prices.size < 2) return 0
        if (prices.size == 2) return Math.max(0, prices[1] - prices[0])

        var currentHolding = prices[0]
        var totalProfit = 0
        for (i in 1 until prices.size) {
            if (prices[i]> currentHolding){
                println("booking profit @ $i from ${currentHolding}")
                totalProfit += prices[i] - currentHolding
            }
            currentHolding = prices[i]
        }
        return totalProfit
    }

}