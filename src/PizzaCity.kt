abstract class PizzaCity(
    val neapolitanPizzaPrice: Double, val romanPizzaPrice: Double,
    val sicilianPizzaPrice: Double, val tyroleanPizzaPrice: Double
) {
    var sauce1Count = 0
    var sauce2Count = 0
    var sauce1Revenue = 0.0
    var sauce2Revenue = 0.0


    var coffeeWithNeapolitan = 0
    var coffeeWithRoman = 0
    var coffeeWithSicilian = 0
    var coffeeWithTyrolean = 0
    var coffeeOfferedCount = 0
    var checkNotShownCount = 0
    var coffeeSoldCount = 0
    var coffeeRevenue = 0.0
    var checkShownCount = 0
    var totalDiscounts = 0.0
    var neapolitanPizzaCount = 0
    var romanPizzaCount = 0
    var sicilianPizzaCount = 0
    var tyroleanPizzaCount = 0

    abstract fun neapolitanPizzaSale()

    abstract fun romanPizzaSale()

    abstract fun sicilianPizzaSale()

    abstract fun tyroleanPizzaSale()
    fun showStatistics() {
        println("Продано сицилийской пиццы: $sicilianPizzaCount")
        println("Продано неаполитанской пиццы: $neapolitanPizzaCount")
        println("Продано римской пиццы: $romanPizzaCount")
        println("Продано тирольской пиццы: $tyroleanPizzaCount")

        val moneyFromPizzas = neapolitanPizzaCount * neapolitanPizzaPrice +
                romanPizzaCount * romanPizzaPrice +
                sicilianPizzaCount * sicilianPizzaPrice +
                tyroleanPizzaCount * tyroleanPizzaPrice

        println("Всего заработано на пиццах: $moneyFromPizzas")
        println("Количество показанных чеков: $checkShownCount")

        val totalChecks = checkShownCount + checkNotShownCount
        if (totalChecks > 0) {
            val shownPercent = checkShownCount * 100.0 / totalChecks
            val notShownPercent = checkNotShownCount * 100.0 / totalChecks
            println("Показывают фотографию чека: $checkShownCount (${String.format("%.2f", shownPercent)}%)")
            println("Не показывают фотографию чека: $checkNotShownCount (${String.format("%.2f", notShownPercent)}%)")
        }

        if (coffeeSoldCount > 0) {
            val buyPercent = coffeeSoldCount * 100.0 / coffeeOfferedCount
            val noBuyPercent = 100 - buyPercent
            println("Покупают кофе: $coffeeSoldCount (${String.format("%.2f", buyPercent)}%)")
            println("Отказываются от кофе: ${coffeeOfferedCount - coffeeSoldCount} (${String.format("%.2f", noBuyPercent)}%)")

            println("Кофе куплено вместе с неаполитанской пиццей: $coffeeWithNeapolitan (${String.format("%.2f", coffeeWithNeapolitan * 100.0 / coffeeSoldCount)}%)")
            println("Кофе куплено вместе с римской пиццей: $coffeeWithRoman (${String.format("%.2f", coffeeWithRoman * 100.0 / coffeeSoldCount)}%)")
            println("Кофе куплено вместе с сицилийской пиццей: $coffeeWithSicilian (${String.format("%.2f", coffeeWithSicilian * 100.0 / coffeeSoldCount)}%)")
            println("Кофе куплено вместе с тирольской пиццей: $coffeeWithTyrolean (${String.format("%.2f", coffeeWithTyrolean * 100.0 / coffeeSoldCount)}%)")
        }

        if (sauce1Count > 0) {
            println("Продано соусов BBQ: $sauce1Count")
            println("Выручка от соусов BBQ: $sauce1Revenue")
        }
        if (sauce2Count > 0) {
            println("Продано чесночных соусов: $sauce2Count")
            println("Выручка от чесночных соусов: $sauce2Revenue")
        }

        if (totalDiscounts > 0) {
            println("Общая сумма скидок: $totalDiscounts")
        }

        val totalRevenue = moneyFromPizzas + coffeeRevenue + sauce1Revenue + sauce2Revenue - totalDiscounts
        println("Всего заработано денег (с учётом кофе, соусов и скидок): $totalRevenue")
    }









}
