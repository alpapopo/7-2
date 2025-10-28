class PizzaPeter(
    neapolitanPizzaPrice: Double, romanPizzaPrice: Double,
    sicilianPizzaPrice: Double, tyroleanPizzaPrice: Double
) : PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
), Drink {

    var currentPizzaType: String? = null
    override fun drinkSale() {
        println("Вы будете кофе?")
        println("1. Да\n2. Нет")
        coffeeOfferedCount++

        if (readln() == "1") {
            coffeeSoldCount++
            coffeeRevenue += 200.0

            when (currentPizzaType) {
                "neapolitan" -> coffeeWithNeapolitan++
                "roman" -> coffeeWithRoman++
                "sicilian" -> coffeeWithSicilian++
                "tyrolean" -> coffeeWithTyrolean++
            }
            println("С вас 200 рублей")
        }
    }

    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        currentPizzaType = "neapolitan"
        println("Спасибо за покупку неаполитанской пиццы в Санкт-Петербурге")
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        currentPizzaType = "roman"
        println("Спасибо за покупку римской пиццы в Санкт-Петербурге")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        currentPizzaType = "sicilian"
        println("Спасибо за покупку сицилийской пиццы в Санкт-Петербурге")
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        currentPizzaType = "tyrolean"
        println("Спасибо за покупку тирольской пиццы в Санкт-Петербурге")
    }
}
